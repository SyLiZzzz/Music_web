package com.demo.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/download")
public class downloadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取下载的文件名
		String fname=request.getParameter("fname");
		String folder="/upload/";//下载文件名
		//两个头通知
		response.addHeader("Content-Type", "application/octet-stream");//内容类型，二进制文件
		response.addHeader("Content-Disposition", "attachment;filename="+fname);//内容配置-文件名为
		//一个流--通过字节流传输文件
		//先读出服务器的资源的字节输入流
		InputStream in =getServletContext().getResourceAsStream(folder+fname);//上下文--获取资源流
		//获取输出到服务器的输出流
		OutputStream out =response.getOutputStream();//输出字节流
		//流的对考
		byte[] buf=new byte[1024];
		int len;
		while((len=in.read(buf))!=-1){
			out.write(buf,0,len);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
