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
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// �����ַ���
		request.setCharacterEncoding("UTF-8");
		// ��Ӧ���ַ���
		response.setContentType("text/html;charset=utf-8");
		// �����û�ʵ��
		String id = request.getParameter("id");
		// ���뵽���ݿ�Ķ�Ӧ����
		int count = BIQWY_USERDao.del(id);
		// �ɹ���ʧ���ض�������
		if (count > 0) {
			response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('�û��б�ɾ��ʧ��')");
			out.write("location.href='manage/admin_douserselect.jsp?cp="+request.getParameter("cpage")+"'");
			out.write("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// �����ַ���
		request.setCharacterEncoding("UTF-8");
		// ��Ӧ���ַ���
		response.setContentType("text/html;charset=utf-8");
		// �����û�ʵ��
		String ids[] = request.getParameterValues("id[]");
		
		for(int i=0;i<ids.length;i++) {
			// ���뵽���ݿ�Ķ�Ӧ����
			BIQWY_USERDao.del(ids[i]);
		}	
		// �ɹ���ʧ���ض�������		
			response.sendRedirect("/biqwy/manage/admin_douserselect");		
	}

}
