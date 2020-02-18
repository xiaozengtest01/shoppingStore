package com.dianbenshu.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dianbenshu.dao.BookDao;
import com.dianbenshu.entiy.Book;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class QueryAllArticle
 */
public class QueryHot extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("’‚ «QueryHot");
		List<Book> books = new ArrayList<Book>();
		try {
			books = BookDao.QueryHot();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(books);
		JSONArray jsonArray = JSONArray.fromObject(books.toArray());
		response.getWriter().print(jsonArray.toString());
	}
}
