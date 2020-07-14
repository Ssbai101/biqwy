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
 * 用户登录
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		// 响应的字符集
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		int count=BIQWY_USERDao.selectByNM(username,password);
	     
		if(count>0) {
			HttpSession session=request.getSession();
			BIQWY_USER user=BIQWY_USERDao.selectAdmin(username,password);
			
			session.setAttribute("name",user);
			session.setAttribute("isLogin","1");
			
			response.sendRedirect("sun/sun_index.jsp");
		}else {
			PrintWriter out=response.getWriter();
			   
			   out.write("<script>");
			   out.write("alert('用户登录失败');");
			   out.write("location.href='index.jsp'");
			   out.write("</script>");
			   out.close();
		}
	}

}
