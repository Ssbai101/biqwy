package com.biqwy.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biqwy.entity.BIQWY_USER;
import com.biqwy.service.BIQWY_USERDao;

/**
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		//响应的字符集
		response.setContentType("text/html;charset=utf-8");
		//创建用户实体
		String username=request.getParameter("username");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String addr=request.getParameter("addr");
		String memo=request.getParameter("memo");
		String userstatus=request.getParameter("userstatus");
		int status=1;
		if(userstatus!=null) {
			status=Integer.parseInt(userstatus);
		}
		BIQWY_USER user=new BIQWY_USER(username,name,password,sex,addr,memo,status);
		//加入到数据库的对应表中
		int count=BIQWY_USERDao.update(user);
		//成功或失败重定向到哪里
	   if(count>0) {
		   response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
	   }else {
		   PrintWriter out=response.getWriter();
		   
		   out.write("<script>");
		   out.write("alert('用户列表修改失败')");
		   out.write("location.href='manage/admin_touserupdate?id="+username+"'");
		   out.write("</script>");
	   }	
	}


}
