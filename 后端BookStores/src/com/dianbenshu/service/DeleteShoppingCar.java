package com.dianbenshu.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dianbenshu.dao.ShoppingCarDao;

/**
 * Servlet implementation class DeleteShoppingCar
 */
public class DeleteShoppingCar extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理乱码，统一字符
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int UserId =  Integer.parseInt(request.getParameter("UserId"));
		String BooksId =  request.getParameter("BooksId");
		int flag=0;
		JSONObject jsonobj = new JSONObject();
		//处理前端传来的数组
		String [] strArr = BooksId.split(",");
		for (int i = 0; i < strArr.length; i++) {
			try {
				flag=ShoppingCarDao.deleteShoppingCar(UserId,Integer.parseInt(strArr[i]));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (flag==0){
				jsonobj.put("code", "-1");
				jsonobj.put("Msg", "移除失败");
				jsonobj.put("BooksId", Integer.parseInt(strArr[i]));
				response.getWriter().print(jsonobj);
				break;
			}
	    }
		jsonobj.put("code", "1");
		jsonobj.put("Msg", "移除成功");
		
		response.getWriter().print(jsonobj);
	}

}
