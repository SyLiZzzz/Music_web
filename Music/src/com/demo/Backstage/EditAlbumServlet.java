package com.demo.Backstage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Album;
import com.demo.service.AdminService;

/**
 * Servlet implementation class EditAlbum
 */
@WebServlet("/EditAlbum")
public class EditAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAlbumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//调用service
		AdminService as = new AdminService();
		//获取表单数据
		Album a = new Album();
		a.setA_id(request.getParameter("a_id"));
		a.setA_name(request.getParameter("a_name"));
		a.setA_singer(request.getParameter("a_singer"));
		boolean b = as.editAlbum(a);
		if(b){
			response.sendRedirect("ListAlbum");
		}else{
			out.println("修改失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
