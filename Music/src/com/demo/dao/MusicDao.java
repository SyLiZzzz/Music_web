package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.demo.bean.Music;
import com.demo.util.c3p0;

public class MusicDao {
	public boolean addMusic(Music m) throws SQLException{
		QueryRunner qr =new QueryRunner(c3p0.ds);
		String sql ="insert into Music (Mname,singer,url,a_id) values (? ,? ,?, ?)";
			int result=qr.update (sql,m.getMname(),m.getSinger(),m.getUrl(),m.getA_id());
		if (result>0) {
			return true;
		}
		
		return false;
	}
	
	public List<Music> findAll() throws SQLException{
		QueryRunner qr =new QueryRunner(c3p0.ds);
		String sql ="select * from  Music ";
		List<Music> list=qr.query(sql, new BeanListHandler<Music>(Music.class));
		return list;
	}
	
	//根据id查找歌曲
	public List<Music> findById(String id) throws SQLException{
		QueryRunner qr =new QueryRunner(c3p0.ds);
		String sql="select * from Music where a_id= ? ";
		List<Music> list = qr.query(sql, new BeanListHandler<Music>(Music.class),id);
		return list;
	}
	
	//根据名字查找歌曲
	public List<Music> findName(String name) throws SQLException{
		QueryRunner qr =new QueryRunner(c3p0.ds);
		String sql="select * from Music where Mname like ? ";
		List<Music> list= qr.query(sql, new BeanListHandler<Music>(Music.class),"%"+name+"%");
		return list;
	}
}
