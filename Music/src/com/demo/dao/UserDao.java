package com.demo.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.demo.bean.User;
import com.demo.util.c3p0;

public class UserDao {
	public boolean addUser(User u ) throws SQLException{
		QueryRunner qr =new QueryRunner(c3p0.ds);
		String sql ="insert into [user] (username,password,gender,age,phone,registTime) values (?, ?, ?, ?, ?, ?)";
		int result=qr.update(sql,u.getUsername(),u.getPassword(),u.getGender(),u.getAge(),u.getPhone(),u.getRegistTime());
		if (result>0) {
			return true;
		}
		return false;
	} 
	
	public User findUser(String username,String password) throws SQLException{
		QueryRunner qr =new QueryRunner(c3p0.ds);
		String sql="select * from [user] where username= ? and password= ?";
		User u =qr.query(sql, new BeanHandler<User>(User.class),username,password);
		return u;
	}
	
	public boolean findPass(User u) throws SQLException{
		QueryRunner qr =new QueryRunner(c3p0.ds);
		String sql="update [user] set password = ? where username = ?";
		int result=qr.update(sql,u.getPassword(),u.getUsername());
		if (result>0) {
			return true;
		}
		return false;
	}
}
