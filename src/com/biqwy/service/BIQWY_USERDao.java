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
   * 删除操作的调用方法，删除一个用户
   * @param id
   * @return
   */
  public static int del(String id) {
	  String sql="delete from BIQWY_USER where id=? and status=1";
	  Object[] params = {id};
	  return basedao.exectuIUD(sql, params);
  }
  /**
   * 添加用户信息
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
   * 用户ajax验证
   * @param id
   * @return
   */
  public static int selectByName(String id) {
      //连接数据库
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
   * 获取总记录数和总页数
   * @param count
   * @return
   */
  public static int[] totalPage(int count,String keyword) {
	  //小标0为总记录数，下标1为页数
	  int arr[] = {0,1};
      //连接数据库
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
      //声明结果集
	  ResultSet rs=null;
	  //获取连接
	  Connection conn=basedao.getconn(); 
	  //预处理
	  PreparedStatement ps=null;
	  
	  
	  try {
		  String sql="";
		  if(keyword!=null) {
			  //书写sql查询语句
			  sql="select *from BIQWY_USER where name like ? order by id desc limit ?,? ";
			  ps=conn.prepareStatement(sql);
			  ps.setString(1, "%"+keyword+"%");
			  //给分页数据赋值
			  ps.setInt(2, (cpage-1)*count);
			  ps.setInt(3, count); 
		  }else {
		  //书写sql查询语句
		    sql="select *from BIQWY_USER order by id desc limit ?,? ";
		    ps=conn.prepareStatement(sql);
		  //给分页数据赋值
			  ps.setInt(1, (cpage-1)*count);
			  ps.setInt(2, count); 
		  }
		  //获取查询数据 
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
   * 通过ID来查找用户
   * @param cpage
   * @param count
   * @param keyword
   * @return
   */
  public static BIQWY_USER selectByID(String id){
	  BIQWY_USER u=null;
      //声明结果集
	  ResultSet rs=null;
	  //获取连接
	  Connection conn=basedao.getconn(); 
	  //预处理
	  PreparedStatement ps=null;
	  
	  try {
		  String sql="select *from BIQWY_USER where id=?";
		  ps=conn.prepareStatement(sql);
		  ps.setString(1, id);
		  //获取查询数据 
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
 * 通过用户名查找
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
   * 通过用户名和密码查询用户信息
   * @param name
   * @param pwd
   * @return
   */
  public static BIQWY_USER selectAdmin(String name,String pwd) {
	  BIQWY_USER u=null;
      //声明结果集
	  ResultSet rs=null;
	  //获取连接
	  Connection conn=basedao.getconn(); 
	  //预处理
	  PreparedStatement ps=null;
	  
	  try {
		  String sql="select *from BIQWY_USER where id=? and password=?";
		  ps=conn.prepareStatement(sql);
		  ps.setString(1,name);
		  ps.setString(2,pwd);
		  //获取查询数据 
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

