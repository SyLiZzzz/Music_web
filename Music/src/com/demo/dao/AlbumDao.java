package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.demo.bean.Album;
import com.demo.bean.Music;
import com.demo.util.c3p0;

public class AlbumDao {
	public boolean addAlbum(Album a) throws SQLException{
		QueryRunner qr =new QueryRunner(c3p0.ds);
		String sql ="insert into Album (a_name,a_singer,a_img) values (? ,? ,?)";
			int result=qr.update (sql,a.getA_name(),a.getA_singer(),a.getA_img());
		if (result>0) {
			return true;
		}
		
		return false;
	}
	//总条数显示
		public int findCount() throws SQLException{
			QueryRunner qr =new QueryRunner(c3p0.ds);
			String sql="select count(*)-1 from Album";
			int count=(int)qr.query(sql, new ScalarHandler<>());//直接查全部歌曲
			return count;
		}
	//分页
		public List<Album> findByPage(int currentPage,int currentCount) throws SQLException{
			QueryRunner qr =new QueryRunner(c3p0.ds);
			List<Album> list =null;
			//直接是全部专辑--无分类
			String sql ="select * from Album where a_id !=0 order by a_id offset "+(currentPage-1)*currentCount+" rows fetch next "+currentCount+" rows only";
			list =qr.query(sql, new BeanListHandler<Album>(Album.class));
			return list;
		}
		
	
}
