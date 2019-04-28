package com.demo.Backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.User;
import com.demo.service.AdminService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户提交的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.调用UserService中的登录方法
		AdminService us = new AdminService();
		User u = us.login(username, password);
		if(u!=null){//登录成功
			//3.保存用户登录状态——把用户存入到session中
			request.getSession().setAttribute("user", u);
			//4.判断用户的角色——超级用户/普通用户
			String role = u.getRole();//获取用户角色
			if("超级用户".equals(role)){//管理员进后台管理
				response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
			}else{//普通用户进前台首页浏览
				response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
			}
		}else{//登录失败
			request.setAttribute("login_msg", "登录失败：1.用户名或密码错误；2.用户还未激活");
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
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
