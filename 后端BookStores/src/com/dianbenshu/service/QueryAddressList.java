package com.dianbenshu.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dianbenshu.dao.AddressDao;
import com.dianbenshu.dao.BookDao;
import com.dianbenshu.dao.ShoppingCarDao;
import com.dianbenshu.entiy.Address;
import com.dianbenshu.entiy.Book;
import com.dianbenshu.entiy.ShoppingCar;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class QueryAddressList
 */
public class QueryAddressList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("����QueryAddressList��");
		request.setCharacterEncoding("UTF-8");// ����ͳһ����!
		response.setContentType("text/html;charset=utf-8"); // 2
		response.setCharacterEncoding("utf-8");
		// ��ȡǰ�˵ĵ�����
		String myId = request.getParameter("myId");
		//�������ж�
		if (myId.trim().equals("null")) {
			System.out.println("��������idΪ��");
		} else {
			System.out.println(myId);
			List<Address> lists = new ArrayList<Address>();
			try {
				lists = AddressDao.QueryAddressList(Integer.parseInt(myId));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(lists);
		
			JSONArray jsonArray = JSONArray.fromObject(lists.toArray());
			response.getWriter().print(jsonArray);

		}
	}

}
