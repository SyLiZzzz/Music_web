package com.demo.util;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;



import com.mchange.v2.c3p0.ComboPooledDataSource;

//数据库连接池-----采用c3p0技术
public class c3p0 {
	public static DataSource ds=null ;//数据源----可以从数据源获取对象Connection
	//给数据源赋值---通过c3p0数据连接池
	static{
		//获取数据连接池
		ComboPooledDataSource bds=new ComboPooledDataSource();
		//给数据源设置参数
		//设置数据库的驱动名:SQLServer/MySql/Oracle数据库
		try {
			bds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//设置数据库的位置:协议,ip地址,端口号,数据库名,
		bds.setJdbcUrl("jdbc:sqlserver://localhost:xxxx;databaseName=xxxx");
		//设置登录用户名
		bds.setUser("xx");
		//设置登录密码
		bds.setPassword("xxxxxxxx");
		//设置连接池初始数量
		bds.setInitialPoolSize(5);
		//设置连接池最大连接数量
		bds.setMaxPoolSize(10);
		//用连接池给数据源赋值
		ds=bds;
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
}
