package com.dianbenshu.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dianbenshu.dao.ShoppingCarDao;
import com.dianbenshu.entiy.ShoppingCar;

/**
 * Servlet implementation class AddShopperCar
 */
public class AddShopperCar extends HttpServlet {

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
		// TODO Auto-generated method stub
		System.out.println("这是AddShopperCar");
		request.setCharacterEncoding("UTF-8");// 处理统一编码!
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取前端数据
		int UserId =  Integer.parseInt(request.getParameter("UserId"));
		int BooksId =  Integer.parseInt(request.getParameter("BooksId"));
		int Num =  Integer.parseInt(request.getParameter("Num"));
		String CreateTime =  request.getParameter("CreateTime");
		String CartMessages = request.getParameter("CartMessages");
		System.out.println(CartMessages);
		//组成一个list
		ShoppingCar list = new ShoppingCar(UserId,BooksId,Num,1,CreateTime,CartMessages);
		//执行语句
		int flag=0;
		JSONObject jsonobj = new JSONObject();
		try {
			flag=ShoppingCarDao.AddShopingCar(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag!=0){
			//返回成功提示
			jsonobj.put("code", "1");
			jsonobj.put("Msg", "增加成功");
		}else{
			jsonobj.put("code", "-1");
			jsonobj.put("Msg", "增加失败");
		}
		response.getWriter().print(jsonobj);
	}

}
