package com.dianbenshu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/bookstore?useUnicode=true&characterEncoding=utf8";
	private static final String user = "root";
	private static final String password = "123456";
	public static Connection connection =null;
	public static PreparedStatement pstmt=null;
	public static ResultSet rs = null;
	//閫氱敤鐨勮幏鍙栬繛鎺ュ璞�
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url,user,password);
	}
	//閫氱敤鐨勮幏鍙杙repareStatement
	public static PreparedStatement createPrepareStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException{
		pstmt = getConnection().prepareStatement(sql);
		if(params != null){
		for (int i=0;i<params.length;i++){
			pstmt.setObject(i+1, params[i]);
			}
		}
		return pstmt;
	}
	//閫氱敤鐨勫鍒犳敼
	public static boolean executeUpdate(String sql,Object[] params){
		try {
			pstmt = createPrepareStatement(sql, params);
			int count = pstmt.executeUpdate();
			if(count>0)
				return true;
			else
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
				closeAll(null,pstmt,connection);
		}
	}
	//鍏抽棴
	public static void closeAll(ResultSet rs,Statement pstmt,Connection connection){
		try {
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if (connection!=null) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//閫氱敤鐨勬煡锛岃繑鍥炰竴涓泦鍚堬拷??
	public static ResultSet executeQuerys(String sql,Object[] params){
		try {
			
			if(params != null){
			for(int i=0;i<params.length;i++){
				pstmt.setObject(i+1, params[i]);
				}
			}else{
				System.out.println("params涓虹┖");
			}
			pstmt = getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			return rs;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
