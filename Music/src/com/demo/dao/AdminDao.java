package com.demo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.demo.bean.Album;
import com.demo.bean.Music;
import com.demo.bean.User;
import com.demo.util.c3p0;

//管理员的dao

public class AdminDao {
	// 查找用户方法
	public User FindUser(String username, String password) throws SQLException {
		// 获得数据库连接池，创建连接
		QueryRunner qr = new QueryRunner(c3p0.ds);
		String sql = "select * from [user] where username = ? and password = ?";
		User u = qr.query(sql, new BeanHandler<User>(User.class), username, password);
		return u;
	}

	// 1.查询所有用户列表的方法
	public List<User> findUser() throws SQLException {
		QueryRunner qr = new QueryRunner(c3p0.ds);
		String sql = "select * from [user]";
		List<User> list = qr.query(sql, new BeanListHandler<User>(User.class));
		return list;
	}

	// 2.根据用户id查询
	public User findUserId(int id) throws SQLException {
		QueryRunner qr = new QueryRunner(c3p0.ds);
		String sql = "select * from [user] where id = ? ";
		User u = qr.query(sql, new BeanHandler<User>(User.class), id);
		return u;
	}

	// 3.根据id修改用户
	public boolean editUser(User u) throws SQLException {
		QueryRunner qr = new QueryRunner(c3p0.ds);
		List<Object> param = new ArrayList<Object>();
		param.add(u.getUsername());
		param.add(u.getGender());
		param.add(u.getAge());
		param.add(u.getPhone());
		param.add(u.getId());
		String sql = "update [user] set username = ? , gender = ? , age = ? , phone = ? where id = ?";
		Object[] objs = param.toArray();
		int result = qr.update(sql, objs);
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 4.根据id删除用户
	public boolean deleteUser(int id) throws SQLException {
		boolean b = false;
		QueryRunner qr = new QueryRunner(c3p0.ds);
		String sql = "delete from [user] where id = ? ";
		int result = qr.update(sql, id);
		if (result > 0) {
			b = true;
		}
		return b;
	}

	// 1.查询所有歌曲列表的方法
	public List<Music> findMusic() throws SQLException {
		QueryRunner qr = new QueryRunner(c3p0.ds);
		String sql = "select * from music";
		List<Music> list = qr.query(sql, new BeanListHandler<Music>(Music.class));
		return list;
	}

	// 2.根据歌曲id查询
	public Music findMusicId(int id) throws SQLException {
		QueryRunner qr = new QueryRunner(c3p0.ds);
		String sql = "select * from music where id = ? ";
		Music m = qr.query(sql, new BeanHandler<Music>(Music.class), id);
		return m;
	}

	// 3.根据id修改歌曲
	public boolean editMusic(Music m) throws SQLException {
		QueryRunner qr = new QueryRunner(c3p0.ds);
		List<Object> param = new ArrayList<Object>();
		param.add(m.getMname());
		param.add(m.getSinger());
		param.add(m.getId());
		String sql = "update music set Mname = ? , singer = ? where id = ?";
		Object[] objs = param.toArray();
		int result = qr.update(sql, objs);
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 4.根据id删除歌曲
	public boolean deleteMusic(int id) throws SQLException {
		boolean b = false;
		QueryRunner qr = new QueryRunner(c3p0.ds);
		String sql = "delete from music where id = ? ";
		int result = qr.update(sql, id);
		if (result > 0) {
			b = true;
		}
		return b;
	}

	// 1.查询所有专辑列表的方法
	public List<Album> findAlbum() throws SQLException {
		QueryRunner qr = new QueryRunner(c3p0.ds);
		String sql = "select * from album";
		List<Album> list = qr.query(sql, new BeanListHandler<Album>(Album.class));
		return list;
	}

	// 2.根据专辑id查询
	public Album findAlbumId(int a_id) throws SQLException {
		QueryRunner qr = new QueryRunner(c3p0.ds);
		String sql = "select * from album where a_id = ? ";
		Album a = qr.query(sql, new BeanHandler<Album>(Album.class), a_id);
		return a;
	}

	// 3.根据id修改专辑
	public boolean editAlbum(Album a) throws SQLException {
		QueryRunner qr = new QueryRunner(c3p0.ds);
		List<Object> param = new ArrayList<Object>();
		param.add(a.getA_name());
		param.add(a.getA_singer());
		param.add(a.getA_id());
		String sql = "update album set a_name = ? , a_singer = ? where a_id = ?";
		Object[] objs = param.toArray();
		int result = qr.update(sql, objs);
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 4.根据id删除歌曲
	public boolean deleteAlbum(int a_id) throws SQLException {
			boolean b = false;
			QueryRunner qr = new QueryRunner(c3p0.ds);
			String sql = "delete from album where a_id = ? ";
			int result = qr.update(sql, a_id);
			if (result > 0) {
				b = true;
			}
			return b;
		}
}
