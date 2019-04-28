package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.bean.Album;
import com.demo.bean.Music;
import com.demo.bean.PageBean;
import com.demo.dao.MusicDao;

import sun.net.www.content.text.plain;

import com.demo.dao.AlbumDao;
public class MusicService {
	MusicDao dao =new MusicDao();
	public List<Music> findAll(){
		List<Music> list =null;
		try {
			list=dao.findAll();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Music> FindName(String name){
		List<Music> list =null;
		try {
			list=dao.findName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  list;
	}

	public List<Music> FindById(String id) {
		List<Music> list=null;
		try {
			list=dao.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
