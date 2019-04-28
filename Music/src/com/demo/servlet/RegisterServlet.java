 package com.demo.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.demo.SMS.RandomNum;
import com.demo.bean.User;
import com.demo.dao.UserDao;
@WebServlet(urlPatterns="/Register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u =new User();
		try {
			u.setUsername(request.getParameter("username"));
			u.setPassword(request.getParameter("password"));
			u.setAge(request.getParameter("age"));
			u.setPhone(request.getParameter("phone"));
			u.setGender(request.getParameter("gender"));
			String code1 =request.getParameter("code");
			String error="";
		if (code1.equals(RandomNum.num)) {
			String time=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			u.setRegistTime(time);
			UserDao ud =new UserDao();
			boolean b =ud.addUser(u);
			if (b) {
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
		}else {
			error="ÑéÖ¤Âë´íÎó";
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
