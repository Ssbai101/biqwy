package com.biqwy.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biqwy.entity.BIQWY_USER;
import com.biqwy.service.BIQWY_USERDao;

import java.io.PrintWriter;
/**
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admin_douseradd")
public class DoUserAdd extends HttpServlet {
     
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ַ���
		request.setCharacterEncoding("UTF-8");
		//��Ӧ���ַ���
		response.setContentType("text/html;charset=utf-8");
		//�����û�ʵ��
		String username=request.getParameter("username");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String addr=request.getParameter("addr");
		String memo=request.getParameter("memo");
		
		BIQWY_USER u=new BIQWY_USER(username,name,password,sex,addr,memo,1);
		//���뵽���ݿ�Ķ�Ӧ����
		int count=BIQWY_USERDao.insert(u);
		//�ɹ���ʧ���ض�������
	   if(count>0) {
		   response.sendRedirect("admin_douserselect");
	   }else {
		   PrintWriter out=response.getWriter();
		   
		   out.write("<script>");
		   out.write("alert('�û��б����ʧ��');");
		   out.write("location.href='manage/admin_useradd.jsp';");
		   out.write("</script>");
	   }	
	}

}
