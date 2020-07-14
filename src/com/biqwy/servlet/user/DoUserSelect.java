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
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cpage=1;//当前页
		int count=5;//每页显示条数
		
		//获取用户指定的页面
		String cp=request.getParameter("cp");
		//接收用户搜索的关键字
		String keyword=request.getParameter("keywords");
		if(cp!=null)
		{
			cpage=Integer.parseInt(cp);	
		}	
		int arr[] = BIQWY_USERDao.totalPage(count,keyword);
		//获取所有的用户记录
		ArrayList<BIQWY_USER> list=BIQWY_USERDao.selectAll(cpage,count,keyword);
		//放入到请求对象域里面
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		if(keyword != null) {
			request.setAttribute("searchParams", "&keywords="+keyword);
		}
		
		
		//重定向
		request.getRequestDispatcher("admin_userlist.jsp").forward(request, response);
		
		
	}

	

}