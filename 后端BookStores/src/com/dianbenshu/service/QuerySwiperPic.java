package com.dianbenshu.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.dianbenshu.dao.BookDao;
import com.dianbenshu.entiy.Book;
import com.dianbenshu.entiy.ShoppingCar;

/**
 * Servlet implementation class QuerySwiperPic
 */
public class QuerySwiperPic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����QuerySwiperPic");
		request.setCharacterEncoding("UTF-8");// ����ͳһ����!
		response.setContentType("text/html;charset=utf-8"); // 2
		response.setCharacterEncoding("utf-8");
		// ��ȡǰ�˵ĵ�����
		String myId = request.getParameter("myId");
		// �������ж�
		if (myId.trim().equals("null")||myId.trim().equals("undefined")) {
			System.out.println("��������idΪ��");
		} else {
			List<String> list = new ArrayList<String>();
			try {
				list = BookDao.QuerySwiperById(Integer.parseInt(myId));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String mylist = JSON.toJSONString(list);
			response.getWriter().print(mylist);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
