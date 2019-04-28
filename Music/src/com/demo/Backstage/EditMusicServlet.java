package com.demo.Backstage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Music;
import com.demo.service.AdminService;

/**
 * Servlet implementation class EditMusicServlet
 */
@WebServlet("/EditMusic")
public class EditMusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMusicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//调用service
		AdminService as = new AdminService();
		//获取表单数据
		Music m = new Music();
		m.setId(request.getParameter("id"));
		m.setMname(request.getParameter("Mname"));
		m.setSinger(request.getParameter("singer"));
		boolean b = as.editMusic(m);
		if(b){
			response.sendRedirect("ListMusic");
		}else{
			out.println("修改失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
