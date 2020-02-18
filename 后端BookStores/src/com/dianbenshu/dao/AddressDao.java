package com.dianbenshu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dianbenshu.entiy.Address;
import com.dianbenshu.entiy.ShoppingCar;
import com.dianbenshu.util.DBUtil;

public class AddressDao {
	// 查询所有用户地址列表
	public static List<Address> QueryAddressList(int myId) throws SQLException {
		List<Address> lists = new ArrayList<Address>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		 
		System.out.println("dao的id:" + myId);
		try {
			conn = DBUtil.getConnection();
			String sql = "select AddressId,AddressName,AddressPhone,AddressDes from address where AddressUserId=" + myId + ";";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int AddressId = rs.getInt("AddressId");
				String AddressName = rs.getString("AddressName");
				String AddressPhone = rs.getString("AddressPhone");
				String AddressDes = rs.getString("AddressDes");
				Address list = new Address(AddressId, AddressName, AddressPhone, AddressDes);
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
	
	
}
