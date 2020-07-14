package com.biqwy.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biqwy.entity.BIQWY_USER;
import com.biqwy.service.BIQWY_USERDao;

/**
 * Servlet implementation class DoManSelect
 */
@WebServlet("/sun/sun_domanselect")
public class DoManSelect extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cpage=1;//褰撳墠椤�
		int count=5;//姣忛〉鏄剧ず鏉℃暟
		
		//鑾峰彇鐢ㄦ埛鎸囧畾鐨勯〉闈�
		String cp=request.getParameter("cp");
		//鎺ユ敹鐢ㄦ埛鎼滅储鐨勫叧閿瓧
		String keyword=request.getParameter("keywords");
		if(cp!=null)
		{
			cpage=Integer.parseInt(cp);	
		}	
		int arr[] = BIQWY_USERDao.totalPage(count,keyword);
		//鑾峰彇鎵�鏈夌殑鐢ㄦ埛璁板綍
		ArrayList<BIQWY_USER> list=BIQWY_USERDao.selectAll(cpage,count,keyword);
		//鏀惧叆鍒拌姹傚璞″煙閲岄潰
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		if(keyword != null) {
			request.setAttribute("searchParams", "&keywords="+keyword);
		}
		
		
		//閲嶅畾鍚�
		request.getRequestDispatcher("sun_userlist.jsp").forward(request, response);
		
		
	}

}
