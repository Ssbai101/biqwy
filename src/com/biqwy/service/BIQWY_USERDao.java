package com.biqwy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.biqwy.dao.basedao;
import com.biqwy.entity.BIQWY_USER;

public class BIQWY_USERDao {
  public static int insert(BIQWY_USER u) {
	  String sql="insert into BIQWY_USER values(?,?,?,?,?,?,?)";
	  
	  Object[] params= {
			  u.getId(),
			  u.getName(),
			  u.getPassword(),
			  u.getSex(),
			  u.getAddr(),
			  u.getMemo(),
			  u.getStatus()};
			  
			return basedao.exectuIUD(sql, params);     
  }
  /**
   * ɾ�������ĵ��÷�����ɾ��һ���û�
   * @param id
   * @return
   */
  public static int del(String id) {
	  String sql="delete from BIQWY_USER where id=? and status=1";
	  Object[] params = {id};
	  return basedao.exectuIUD(sql, params);
  }
  /**
   * ����û���Ϣ
   * @param u
   * @return
   */
  public static int update(BIQWY_USER u) {
	  String sql="update BIQWY_USER set name=?,password=?,sex=?,addr=?,memo=?,status=? where id=?";
	  
	  Object[] params= {
			  u.getName(),
			  u.getPassword(),
			  u.getSex(),
			  u.getAddr(),
			  u.getMemo(),
			  u.getStatus(),
			  u.getId()};
			  
			return basedao.exectuIUD(sql, params);     
  }
  /**
   * �û�ajax��֤
   * @param id
   * @return
   */
  public static int selectByName(String id) {
      //�������ݿ�
	  int count=0;
	  Connection conn=basedao.getconn();
      PreparedStatement ps= null;
      ResultSet rs = null;
      
      
      try {
    	  String sql="select count(*) from BIQWY_USER where id =?";
    	  ps=conn.prepareStatement(sql);
		  ps.setString(1, id);
          rs=ps.executeQuery();
          
    	  while(rs.next()) {
    		  count = rs.getInt(1);
    		  }  
      }catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		basedao.closeall(rs, ps, conn);
	}
	  return count;
  }
  
  /**
   * ��ȡ�ܼ�¼������ҳ��
   * @param count
   * @return
   */
  public static int[] totalPage(int count,String keyword) {
	  //С��0Ϊ�ܼ�¼�����±�1Ϊҳ��
	  int arr[] = {0,1};
      //�������ݿ�
	  Connection conn=basedao.getconn();
      PreparedStatement ps= null;
      ResultSet rs = null;
      
      
      try {
    	  String sql="";
    	  if(keyword!=null) {
    		  sql ="select count(*) from BIQWY_USER where name like ?";
    		  ps=conn.prepareStatement(sql);
    		  ps.setString(1, "%"+keyword+"%");
    	  }else {
    		  sql ="Select count(*) from BIQWY_USER";
    		  ps=conn.prepareStatement(sql);
    	  }
     
        
    	      rs=ps.executeQuery();
    	  
    	  while(rs.next()) {
    		  arr[0] = rs.getInt(1);
    		  if(arr[0]%count==0) {
    		  arr[1] = arr[0]/count;
    	  }else {
    		  arr[1] = arr[0]/count+1;
    	  }
    	}  
      }catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		basedao.closeall(rs, ps, conn);
	}
	  return arr;
  }
  
  
  public static ArrayList<BIQWY_USER> selectAll(int cpage,int count,String keyword){
	  ArrayList<BIQWY_USER> list=new ArrayList<BIQWY_USER>();
      //���������
	  ResultSet rs=null;
	  //��ȡ����
	  Connection conn=basedao.getconn(); 
	  //Ԥ����
	  PreparedStatement ps=null;
	  
	  
	  try {
		  String sql="";
		  if(keyword!=null) {
			  //��дsql��ѯ���
			  sql="select *from BIQWY_USER where name like ? order by id desc limit ?,? ";
			  ps=conn.prepareStatement(sql);
			  ps.setString(1, "%"+keyword+"%");
			  //����ҳ���ݸ�ֵ
			  ps.setInt(2, (cpage-1)*count);
			  ps.setInt(3, count); 
		  }else {
		  //��дsql��ѯ���
		    sql="select *from BIQWY_USER order by id desc limit ?,? ";
		    ps=conn.prepareStatement(sql);
		  //����ҳ���ݸ�ֵ
			  ps.setInt(1, (cpage-1)*count);
			  ps.setInt(2, count); 
		  }
		  //��ȡ��ѯ���� 
		  rs=ps.executeQuery();
		  while(rs.next()) {
			  BIQWY_USER u=new BIQWY_USER(
					  rs.getString("id"),
					  rs.getString("name"),
					  rs.getString("password"),
					  rs.getString("sex"),
					  rs.getString("addr"),
					  rs.getString("memo"),
					  rs.getInt("status")
					  ); 
			  list.add(u);
		  }
		  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		basedao.closeall(rs, ps, conn);
	}
	  
	  return list;
  }
  /**
   * ͨ��ID�������û�
   * @param cpage
   * @param count
   * @param keyword
   * @return
   */
  public static BIQWY_USER selectByID(String id){
	  BIQWY_USER u=null;
      //���������
	  ResultSet rs=null;
	  //��ȡ����
	  Connection conn=basedao.getconn(); 
	  //Ԥ����
	  PreparedStatement ps=null;
	  
	  try {
		  String sql="select *from BIQWY_USER where id=?";
		  ps=conn.prepareStatement(sql);
		  ps.setString(1, id);
		  //��ȡ��ѯ���� 
		  rs=ps.executeQuery();
		  while(rs.next()) {
			   u=new BIQWY_USER(
					  rs.getString("id"),
					  rs.getString("name"),
					  rs.getString("password"),
					  rs.getString("sex"),
					  rs.getString("addr"),
					  rs.getString("memo"),
					  rs.getInt("status")
					  ); 
			 
		  }
		  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		basedao.closeall(rs, ps, conn);
	}
	  
	  return u;
  }
/**
 * ͨ���û�������
 */
  public static int selectByNM(String name,String pwd) {
	  int count=0;
	  
	  Connection conn=basedao.getconn();
      PreparedStatement ps= null;
      ResultSet rs = null;
      
      
      try {
    	  String sql="select count(*) from BIQWY_USER where id=? and password=?";
    	  ps=conn.prepareStatement(sql);
		  ps.setString(1, name);
		  ps.setString(2, pwd);
          rs=ps.executeQuery();
    	  
    	  while(rs.next()) {
    		  count = rs.getInt(1);
    		  
    	}  
      }catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		basedao.closeall(rs, ps, conn);
	} 
	  return count;
  }
  /**
   * ͨ���û����������ѯ�û���Ϣ
   * @param name
   * @param pwd
   * @return
   */
  public static BIQWY_USER selectAdmin(String name,String pwd) {
	  BIQWY_USER u=null;
      //���������
	  ResultSet rs=null;
	  //��ȡ����
	  Connection conn=basedao.getconn(); 
	  //Ԥ����
	  PreparedStatement ps=null;
	  
	  try {
		  String sql="select *from BIQWY_USER where id=? and password=?";
		  ps=conn.prepareStatement(sql);
		  ps.setString(1,name);
		  ps.setString(2,pwd);
		  //��ȡ��ѯ���� 
		  rs=ps.executeQuery();
		  while(rs.next()) {
			   u=new BIQWY_USER(
					  rs.getString("id"),
					  rs.getString("name"),
					  rs.getString("password"),
					  rs.getString("sex"),
					  rs.getString("addr"),
					  rs.getString("memo"),
					  rs.getInt("status")
					  ); 
			 
		  }
		  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		basedao.closeall(rs, ps, conn);
	}
	  
	  return u;
  }
}

