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

import com.dianbenshu.entiy.User;
import com.dianbenshu.util.DBUtil;

public class UserDao {
	// 登录功能
	public static int login(String Name, String Password) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		int myId = 0;
		int flag = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "select UserId,UserPassword  from user where UserName='" + Name + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			System.out.println(rs);
			while (rs.next()) {
				myId = rs.getInt("UserId");
				result = rs.getString("UserPassword");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		if (Password.equals(result)) {
			flag = myId;
		}
		return flag;
	}

	// 查询全部文章
//	public static List<Book> QueryHot() throws SQLException {
//		List<Book> books = new ArrayList<Book>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		Book book = new Book();
//		try {
//			conn = DBUtil.getConnection();
//			String sql = "select BookId,BookName,BookCover,BookPrice,BookAuthor  from books;";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				int BookId = rs.getInt("BookId");
//				String BookName = rs.getString("BookName");
//				String BookCover = rs.getString("BookCover");
//				double BookPrice = rs.getDouble("BookPrice");
//				String BookAuthor = rs.getString("BookAuthor");
//				book = new Book(BookId, BookName, BookCover, BookPrice, BookAuthor);
//				books.add(book);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (rs != null)
//				rs.close();
//			if (pstmt != null)
//				pstmt.close();
//			if (conn != null)
//				conn.close();
//		}
//		return books;
//	}
}
