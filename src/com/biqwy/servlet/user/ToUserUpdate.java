package com.biqwy.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biqwy.entity.BIQWY_USER;
import com.biqwy.service.BIQWY_USERDao;

/**
 * Servlet implementation class ToUserUpdate
 */
@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/heml;charset=utf-8");
		
		String id = request.getParameter("id");
		//閫氳繃ID鍒版暟鎹噷鏌ユ壘
		BIQWY_USER user=BIQWY_USERDao.selectByID(id);
		//鎶妘ser鐢ㄦ埛娣诲姞鍒颁慨鏀圭殑椤甸潰
		request.setAttribute("user", user);
		
		request.setAttribute("cpage", request.getParameter("cpage"));
		//閲嶅畾鍚�
		request.getRequestDispatcher("admin_usermodify.jsp").forward(request, response);
	}
}
