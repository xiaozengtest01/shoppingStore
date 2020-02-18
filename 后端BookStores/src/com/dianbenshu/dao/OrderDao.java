package com.dianbenshu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dianbenshu.entiy.Order;
import com.dianbenshu.entiy.Order_Book;
import com.dianbenshu.entiy.ShoppingCar;
import com.dianbenshu.util.DBUtil;

public class OrderDao {
	// 增加一个订单
	public static int AddOrder(Order list) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO orders (Order_number,UserId,Pay_price,Is_pay,Pay_time,Is_ship,Ship_time,Is_receipt,Receipt_time,Ship_number,Status,Create_time,Update_time) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			// 插入数据后获取自增的id
			pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, list.getOrder_number());
			pstmt.setInt(2, list.getUserId());
			pstmt.setInt(3, list.getPay_price());
			pstmt.setInt(4, list.getIs_pay());
			pstmt.setString(5, list.getPay_time());
			pstmt.setInt(6, list.getIs_ship());
			pstmt.setString(7, list.getShip_time());
			pstmt.setInt(8, list.getIs_receipt());
			pstmt.setString(9, list.getReceipt_time());
			pstmt.setString(10, list.getShip_number());
			pstmt.setInt(11, list.getStatus());
			pstmt.setString(12, list.getCreate_time());
			pstmt.setString(13, list.getUpdate_time());
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

	// 增加一个订单具体物件
	public static int AddOrder_Book(Order_Book list) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO order_book (Order_number,BookId,BookNum) VALUES(?,?,?)";
			// 插入数据后获取自增的id
			pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, list.getOrder_number());
			pstmt.setInt(2, list.getBookId());
			pstmt.setInt(3, list.getBookNum());

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
}
