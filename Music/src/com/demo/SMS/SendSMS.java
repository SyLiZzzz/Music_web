package com.demo.SMS;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class SendSMS
 */
@WebServlet("/SendSMS")
public class SendSMS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendSMS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String phone=request.getParameter("phone");
		RandomNum randomNum=new RandomNum();
		RandomNum.num=randomNum.getRandom();
		String json= IndustrySMS.execute(phone,RandomNum.num);
		request.setAttribute("phone",phone);
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		 String result=obj.get("respCode").getAsString();
		 if(result.equals("00000")){
			 request.setAttribute("msg", "验证码发送成功");
		 }else if(result.equals("00126")){
			 request.setAttribute("msg", "手机号格式不正确");
		}
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

}
