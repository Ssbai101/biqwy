package com.biqwy.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class basedao {
	static {
	     //��������
	   try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	
	//���� 
	public static Connection getconn(){
		//����һ�����Ӷ��� 
		Connection conn=null;
        try {
        	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/biqwy?useSSL=false&serverTimezone=UTC","root","admin");
        }catch(SQLException e) {
               	e.printStackTrace();
        }
        return conn;
	}
	//���ݿ����ɾ�Ĳ�
public static int exectuIUD(String sql,Object[] params) {
	int count=0;
		Connection conn=basedao.getconn();
		//׼��sql���
		PreparedStatement ps=null;
	try {
			//׼��sql���,��prepareStatement������
		ps=conn.prepareStatement(sql);
		   //�󶨲���
		for(int i=0;i<params.length;i++) {
		ps.setObject(i+1, params[i]);
		}
		//ִ��
		count=ps.executeUpdate();
	}catch(SQLException e) {
           	e.printStackTrace();
    }finally {
    	 basedao.closeall(null, ps, conn);
    }
	
	        return count;
	}
	//�ر�
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
