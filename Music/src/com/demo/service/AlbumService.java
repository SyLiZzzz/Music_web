package com.demo.service;

import java.util.List;

import com.demo.bean.Album;
import com.demo.bean.Music;
import com.demo.bean.PageBean;
import com.demo.dao.AlbumDao;

public class AlbumService {
	//分页操作
		public PageBean findMusicByPage(int currentPage,int currentCount){
			AlbumDao dao =new AlbumDao();
			PageBean bean =new PageBean();
			//封装每页显示的数据条数
			bean.setCurrentCount(currentCount);
			//封装当前页码
			bean.setCurrentPage(currentPage);
			try {
				int totalCount=dao.findCount();
				//封装总记录条数
				bean.setTotalCount(totalCount);
				//求出总页数 ==ceil(总页数/每条页数)向上取整
				int totalPage=(int )Math.ceil(totalCount*1.0/currentCount);
				//封装总页数
				bean.setTotalPage(totalPage);
				//调用dao包方法，获取当前页的数据
				List<Album> ps =dao.findByPage(currentPage, currentCount);
				//封装
				bean.setPs(ps);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return bean;
		}
		
	
}
