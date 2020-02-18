package com.dianbenshu.dao;

import java.sql.Array;
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

import com.dianbenshu.entiy.Book;
import com.dianbenshu.util.DBUtil;

public class BookDao {

	// 查询全部书本
	public static List<Book> QueryHot() throws SQLException {
		List<Book> books = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = new Book();
		try {
			conn = DBUtil.getConnection();
			String sql = "select BookId,BookName,BookCover,BookPrice,BookAuthor from books;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int BookId = rs.getInt("BookId");
				String BookName = rs.getString("BookName");
				String BookCover = rs.getString("BookCover");
				double BookPrice = rs.getDouble("BookPrice");
				String BookAuthor = rs.getString("BookAuthor");
				book = new Book(BookId, BookName, BookCover, BookPrice, BookAuthor);
				books.add(book);
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
		return books;
	}


	// 根据Id查询书本
	public static Book QueryById(int myId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = new Book();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from books where BookId="+myId+";";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int BookId = rs.getInt("BookId");
				String BookName = rs.getString("BookName");
				int BookNum = rs.getInt("BookNum");
				String BookCover = rs.getString("BookCover");
				int BookClass = rs.getInt("BookClass");
				double BookPrice = rs.getDouble("BookPrice");
				String BookDes = rs.getString("BookDes");
				String BookAuthor = rs.getString("BookAuthor");
				String BookPublish = rs.getString("BookPublish");
				book = new Book(BookId, BookName, BookNum, BookCover, BookClass,BookPrice, BookDes,BookAuthor,BookPublish);
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
		return book;
	}
	
	// 根据Id查询书本的滑动图片
	public static List<String> QuerySwiperById(int myId) throws SQLException {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<String> list=new ArrayList<String>();
			try {
				conn = DBUtil.getConnection();
				String sql = "select PicUrl from bookswiperpic where BookId="+myId+";";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					list.add(rs.getString("PicUrl"));
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
			return list;
		}
}
