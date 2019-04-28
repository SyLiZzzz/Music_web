package com.demo.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.demo.bean.Music;
import com.demo.dao.MusicDao;

@WebServlet(urlPatterns="/upload")
public class uploadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建工厂对象
		try {
		DiskFileItemFactory factory =new DiskFileItemFactory();
		File f =new File("E:\\Temp");//优化,解决内存溢出
		if (!f.exists()) {//如果不存在就建立一个新的文件夹
			f.mkdirs();
		}
		factory.setRepository(f);//设置缓存路径
		//通过工厂对象，获得解析器对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("utf-8");
		//通过解析器对象，解析request中的表单文件，分为普通字段和文件字段
		List<FileItem> flist =sfu.parseRequest(request);
		//用来封装表单数据的javaBean对象
		Music m =new Music();
		//循环分情况处理list集合中的表单字段(普通字段和文件字段)
		for (FileItem item : flist) {
			if (item.isFormField()) {//判断是否是普通字段，如果是则继续普通字段处理else则进行文件字段处理
				String name=item.getFieldName();
				//获取字段值
				String value =item.getString("utf-8");//由于可能初夏乱码使用带参数的方法
				if ("Mname".equals(name)) {
					m.setMname(value);
				}
				if ("singer".equals(name)) {
					m.setSinger(value);
				}
				if ("a_id".equals(name)) {
					m.setA_id(value);
				}
			}else {
				String fname=item.getName();//获取上传文件的文件名
				//截取后段文件名
				fname =fname.substring(fname.lastIndexOf("."));//从点取
				fname=UUID.randomUUID().toString()+fname;//避免文件重
				m.setUrl(fname);
				String webpath="/upload/";//在服务器创建文件夹
				//将服务器中文件夹路径和文件名组合成完整的服务器端路径
				String filepath =getServletContext().getRealPath(webpath+fname);
				//用字节流写文件
				File file =new File(filepath);
				//创建你上层文件夹upload
				file.getParentFile().mkdirs();
				file.createNewFile();//创建文件
				InputStream in =item.getInputStream();
				//创建输出流， 打开服务器端的文件上传
				FileOutputStream fout = new FileOutputStream(file);
				//流的对拷
				byte[] buf=new byte[1024];//每次读取1个字节
				int len;//一次读取缓存的长度
				//开始读取上传文件的字节,并将其输出到服务器的上传文件输出中
				while((len=in.read(buf))>0){
					fout.write(buf, 0, len);
				}
				//关闭流
				in.close();
				fout.close();
				//删除临时文件
				item.delete();
			}
		}
			MusicDao md =new MusicDao();
			boolean result=md.addMusic(m);
			if (result) {
				response.sendRedirect("listMusic");
			}else{
				response.getWriter().println("error");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
