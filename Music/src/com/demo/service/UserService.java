package com.demo.service;

import java.sql.SQLException;

import com.demo.bean.User;
import com.demo.dao.UserDao;

public class UserService {
	public User loginUser(String username,String password){
		UserDao dao=new UserDao();
		try {
			User u=dao.findUser(username, password);
			if (u!=null) {
				return u;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
