package com.dianbenshu.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.dianbenshu.entiy.ShoppingCar;
import com.dianbenshu.util.DBUtil;

public class ShoppingCarDao {

	// 查询所有购物车清单
	public static List<ShoppingCar> QueryShoppingCar(int myId) throws SQLException {
		List<ShoppingCar> lists = new ArrayList<ShoppingCar>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShoppingCar list = new ShoppingCar();
		System.out.println("dao的id:" + myId);
		try {
			conn = DBUtil.getConnection();
			String sql = "select ShoppingCarId,BooksId,Num from shoppingcar where Status=1 and UserId=" + myId + ";";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int ShoppingCarId = rs.getInt("ShoppingCarId");
				int BooksId = rs.getInt("BooksId");
				int Num = rs.getInt("Num");
				list = new ShoppingCar(ShoppingCarId, BooksId, Num);
				lists.add(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return lists;
	}

	// 增加购物车的清单
	public static int AddShopingCar(ShoppingCar list) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO shoppingcar (UserId,BooksId,Num,Status,CreateTime,CartMessages) VALUES(?,?,?,?,?,?)";
			// 插入数据后获取自增的id
			pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, list.getUserId());
			pstmt.setInt(2, list.getBooksId());
			pstmt.setInt(3, list.getNum());
			pstmt.setInt(4, list.getStatus());
			pstmt.setString(5, list.getCreateTime());
			pstmt.setString(6, list.getCartMessages());
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}
	
	//删除购物车书本
	public static int deleteShoppingCar(int userId,int bookid) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn =DBUtil.getConnection();
			String sql = "delete from shoppingcar where BooksId=? and UserId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,bookid);
			pstmt.setInt(2,userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null) pstmt.close();else return result;
			if(conn!=null)conn.close();else return result;
		}
		return result;
	}
}
