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
		System.out.println("这是QuerySwiperPic");
		request.setCharacterEncoding("UTF-8");// 处理统一编码!
		response.setContentType("text/html;charset=utf-8"); // 2
		response.setCharacterEncoding("utf-8");
		// 获取前端的的数据
		String myId = request.getParameter("myId");
		// 合理性判断
		if (myId.trim().equals("null")||myId.trim().equals("undefined")) {
			System.out.println("传进来的id为空");
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
