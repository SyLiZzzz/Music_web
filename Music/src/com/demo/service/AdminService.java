package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.bean.Album;
import com.demo.bean.Music;
import com.demo.bean.User;
import com.demo.dao.AdminDao;

//管理员的业务逻辑service类
public class AdminService {
	// 调用dao包
	AdminDao dao = new AdminDao();

	// 用户登录功能方法
	public User login(String username, String password) {
		try {
			User u = dao.FindUser(username, password);
			if (u != null) {
				return u;// 返回成功用户
			} else {
				System.out.println("用户名或密码错误");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 1.查询所有用户的方法
	public List<User> findUser() {
		List<User> list = null;
		try {
			list = dao.findUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2.根据用户id查询
	public User findUserId(int id) {
		User u = null;
		try {
			u = dao.findUserId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	// 3.根据id修改用户
	public boolean editUser(User u) {
		boolean b = false;
		try {
			b = dao.editUser(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// 4.根据id删除
	public boolean deleteUser(int id) {
		boolean b = false;
		try {
			b = dao.deleteUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// 1.查询所有用户的方法
	public List<Music> findMusic() {
		List<Music> list = null;
		try {
			list = dao.findMusic();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2.根据用户id查询
	public Music findMusicId(int id) {
		Music m = null;
		try {
			m = dao.findMusicId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	// 3.根据id修改用户
	public boolean editMusic(Music m) {
		boolean b = false;
		try {
			b = dao.editMusic(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// 4.根据id删除歌曲
	public boolean deleteMusic(int id) {
		boolean b = false;
		try {
			b = dao.deleteMusic(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// 1.查询所有歌曲列表的方法
	public List<Album> findAlbum() {
		List<Album> list = null;
		try {
			list = dao.findAlbum();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2.根据专辑id查询
	public Album findAlbumId(int a_id) {
		Album a = null;
		try {
			a = dao.findAlbumId(a_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	// 3.根据id修改专辑
	public boolean editAlbum(Album a){
		boolean b = false;
		try {
			b = dao.editAlbum(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// 4.根据id删除歌曲
	public boolean deleteAlbum(int a_id){
		boolean b = false;
		try {
			b = dao.deleteAlbum(a_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b ;
	}
}
