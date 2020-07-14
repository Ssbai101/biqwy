package com.biqwy.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class basedao {
	static {
	     //加载驱动
	   try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	
	//连接 
	public static Connection getconn(){
		//创建一个连接对象 
		Connection conn=null;
        try {
        	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/biqwy?useSSL=false&serverTimezone=UTC","root","admin");
        }catch(SQLException e) {
               	e.printStackTrace();
        }
        return conn;
	}
	//数据库的增删改查
public static int exectuIUD(String sql,Object[] params) {
	int count=0;
		Connection conn=basedao.getconn();
		//准备sql语句
		PreparedStatement ps=null;
	try {
			//准备sql语句,用prepareStatement来声明
		ps=conn.prepareStatement(sql);
		   //绑定参数
		for(int i=0;i<params.length;i++) {
		ps.setObject(i+1, params[i]);
		}
		//执行
		count=ps.executeUpdate();
	}catch(SQLException e) {
           	e.printStackTrace();
    }finally {
    	 basedao.closeall(null, ps, conn);
    }
	
	        return count;
	}
	//关闭
  public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn) {
	  try {
		  if(rs!=null)
	          rs.close();
		  if(ps!=null)
			  ps.close();
		  if(conn!=null)
			  conn.close(); 				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}
