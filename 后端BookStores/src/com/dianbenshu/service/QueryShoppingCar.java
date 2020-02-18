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
import com.dianbenshu.dao.ShoppingCarDao;
import com.dianbenshu.entiy.Book;
import com.dianbenshu.entiy.ShoppingCar;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class QueryShoppingCar
 */
public class QueryShoppingCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("这是QueryShoppingCar！");
		request.setCharacterEncoding("UTF-8");// 处理统一编码!
		response.setContentType("text/html;charset=utf-8"); // 2
		response.setCharacterEncoding("utf-8");
		// 获取前端的的数据
		String myId = request.getParameter("myId");
		//合理性判断
		if (myId.trim().equals("null")) {
			System.out.println("传进来的id为空");
		} else {
			System.out.println(myId);
			List<ShoppingCar> lists = new ArrayList<ShoppingCar>();
			List<Book> books = new ArrayList<Book>();
			try {
				lists = ShoppingCarDao.QueryShoppingCar(Integer.parseInt(myId));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(lists);
			for (ShoppingCar list : lists) {
				System.out.println(list.getBooksId());
				try {
					Book book = BookDao.QueryById(list.getBooksId());
					book.setBookNum(list.getNum());
					books.add(book);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(books.toArray());
			response.getWriter().print(jsonArray);

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
