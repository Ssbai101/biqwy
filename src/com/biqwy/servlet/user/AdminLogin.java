package com.biqwy.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biqwy.entity.BIQWY_USER;
import com.biqwy.service.BIQWY_USERDao;

/**
 * 管理员登录
 * Servlet implementation class AdminLogin
 */
@WebServlet("/sun/adminlogin")
public class AdminLogin extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		// 响应的字符集
		response.setContentType("text/html;charset=utf-8");
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		int count=BIQWY_USERDao.selectByNM(name,password);
	     
		if(count>0) {
			
			BIQWY_USER user=BIQWY_USERDao.selectAdmin(name,password);
			HttpSession session=request.getSession();
			session.setAttribute("name",user);
			session.setAttribute("isLogin","1");
			
			if(user.getStatus() == 2){
				session.setAttribute("isAdminLogin","1");
				response.sendRedirect("biqwy/manage/admin_index.jsp");
			}else {
				response.sendRedirect("sun/sun_index.jsp");
			}
			
		}else {
			PrintWriter out=response.getWriter();
			   
			   out.write("<script>");
			   out.write("alert('用户登录失败');");
			   out.write("location.href='hlogin.jsp';");
			   out.write("</script>");
			   out.close();
		}
	}

}
