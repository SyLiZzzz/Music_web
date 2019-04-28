package com.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.PageBean;
import com.demo.service.AlbumService;
import com.demo.service.MusicService;
@WebServlet(urlPatterns="/FindByPage")
public class FindByPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.定义当前的页码为第一页
		int currentPage=1;
		String page =request.getParameter("currentPage");
		if (page!=null) {
			currentPage=Integer.parseInt(page);
		}
		//定义每页显示条数---4条/页
		int currentCount=4;
		String count=request.getParameter("currentCount");
		if (count!=null) {
			currentCount=Integer.parseInt(count);
		}
		//调用service分页显示歌曲方法。获取当前页的bean数据
		AlbumService as =new AlbumService();
		PageBean bean =as.findMusicByPage(currentPage, currentCount);
		//把查询获取的数据存入到request请求域参数
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
