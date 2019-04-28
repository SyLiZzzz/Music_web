package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.SMS.RandomNum;
import com.demo.bean.User;
import com.demo.dao.UserDao;
@WebServlet(urlPatterns="/forget")
public class forgetPassword extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u =new User();
		try {
			u.setUsername(request.getParameter("username"));
			u.setPassword(request.getParameter("password"));
			String code1 =request.getParameter("code");
		if (code1.equals(RandomNum.num)) {
			UserDao ud =new UserDao();
			boolean b =ud.findPass(u);
			if (b) {
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
		}else {
			System.out.println("Ê§°Ü");
		}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
