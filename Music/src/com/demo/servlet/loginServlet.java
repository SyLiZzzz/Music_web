package com.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.User;
import com.demo.service.UserService;
@WebServlet(urlPatterns="/login")
public class loginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username= request.getParameter("username");
		String password=request.getParameter("password");
		UserService us =new UserService();
		User u =us.loginUser(username, password);
		if (u!=null) {
			request.getSession().setAttribute("user", u);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			request.setAttribute("login_msg", "µÇÂ¼Ê§°Ü:ÓÃ»§Ãû»òÃÜÂë´íÎó");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
