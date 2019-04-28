package com.demo.Backstage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.User;
import com.demo.dao.AdminDao;
import com.demo.service.AdminService;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUser")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
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
		User u = new User();
		u.setId(Integer.parseInt(request.getParameter("id")));
		u.setUsername(request.getParameter("username"));
		u.setGender(request.getParameter("gender"));
		u.setAge(request.getParameter("age"));
		u.setPhone(request.getParameter("phone"));
		boolean b = as.editUser(u);
		if(b){
			response.sendRedirect("ListUser");
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
