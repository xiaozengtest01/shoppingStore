package com.dianbenshu.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dianbenshu.dao.BookDao;
import com.dianbenshu.dao.ShoppingCarDao;
import com.dianbenshu.entiy.Book;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class QueryBookById
 */
public class QueryBookById extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("这是querybookbyid");
		request.setCharacterEncoding("UTF-8");// 处理统一编码!
		response.setContentType("text/html;charset=utf-8"); // 2
		response.setCharacterEncoding("utf-8");
		// 获取前端的的数据
		String myId = request.getParameter("myId");
		JSONObject jsonobj = new JSONObject();
		// 合理性判断
		if (myId.trim().equals("null")||myId.trim().equals("undefined")) {
			System.out.println("传进来的id为空");
		} else {
			Book book = new Book();
			try {
				book = BookDao.QueryById(Integer.parseInt(myId));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String myBook = JSON.toJSONString(book);
			response.getWriter().print(myBook);
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
