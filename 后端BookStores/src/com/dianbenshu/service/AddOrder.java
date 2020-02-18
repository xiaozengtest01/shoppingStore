package com.dianbenshu.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dianbenshu.dao.OrderDao;
import com.dianbenshu.dao.ShoppingCarDao;
import com.dianbenshu.entiy.Order;
import com.dianbenshu.entiy.Order_Book;
import com.dianbenshu.entiy.ShoppingCar;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddOrder
 */
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����AddOrder");
		request.setCharacterEncoding("UTF-8");// ����ͳһ����!
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// ��ȡǰ������

		String Order_number = request.getParameter("Order_number");
		int UserId = Integer.parseInt(request.getParameter("UserId"));
		int Pay_price = Integer.parseInt(request.getParameter("Pay_price"));
		String Create_time = request.getParameter("Create_time");
		JSONArray books = JSONArray.fromObject(request.getParameter("books"));
		String str = "";

		Order list = new Order(Order_number, UserId, Pay_price, 0, str, 0, str, 0, str, str, 1, Create_time,
				Create_time);

		// ִ�����
		int flag = 0;
		int flags = 0;
		JSONObject jsonobj = new JSONObject();
		try {
			flag = OrderDao.AddOrder(list);
			for (int i = 0; i < books.size(); i++) {
				flags = 0;
				JSONObject book = books.getJSONObject(i);// ��ÿһ������ת��json����
				Order_Book order_book = new Order_Book(Order_number, book.getInt("bookId"), book.getInt("bookNum"));
				flags = OrderDao.AddOrder_Book(order_book);
				flags = ShoppingCarDao.deleteShoppingCar(UserId,book.getInt("bookId"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag != 0 && flags != 0) {
			// ���سɹ���ʾ
			jsonobj.put("code", "1");
			jsonobj.put("Msg", "���ӳɹ�");
		} else {
			jsonobj.put("code", "-1");
			jsonobj.put("Msg", "����ʧ��");
		}
		response.getWriter().print(jsonobj);
	}

}
