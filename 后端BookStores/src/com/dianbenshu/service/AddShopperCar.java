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
		System.out.println("����AddShopperCar");
		request.setCharacterEncoding("UTF-8");// ����ͳһ����!
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// ��ȡǰ������
		int UserId =  Integer.parseInt(request.getParameter("UserId"));
		int BooksId =  Integer.parseInt(request.getParameter("BooksId"));
		int Num =  Integer.parseInt(request.getParameter("Num"));
		String CreateTime =  request.getParameter("CreateTime");
		String CartMessages = request.getParameter("CartMessages");
		System.out.println(CartMessages);
		//���һ��list
		ShoppingCar list = new ShoppingCar(UserId,BooksId,Num,1,CreateTime,CartMessages);
		//ִ�����
		int flag=0;
		JSONObject jsonobj = new JSONObject();
		try {
			flag=ShoppingCarDao.AddShopingCar(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag!=0){
			//���سɹ���ʾ
			jsonobj.put("code", "1");
			jsonobj.put("Msg", "���ӳɹ�");
		}else{
			jsonobj.put("code", "-1");
			jsonobj.put("Msg", "����ʧ��");
		}
		response.getWriter().print(jsonobj);
	}

}
