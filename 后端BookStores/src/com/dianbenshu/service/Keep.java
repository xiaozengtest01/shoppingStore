package com.dianbenshu.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class Keep
 */
public class Keep extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Cookie[] cookies = request.getCookies();
		System.out.println(cookies);
		JSONObject jsonobj = new JSONObject();
		System.out.println("sessionId:" + session.getId());
		// 遍历客户端传递过来的cookie
		if(cookies!=null){
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if (c.getName().equals("Sid")) {
					System.out.println("我是keep中的Sid"+c.getValue());
					if(c.getValue().equals(session.getId())){
						jsonobj.put("code", "1");
						jsonobj.put("Msg", "已经登录");
						response.getWriter().print(jsonobj);
						return;
					}
				}
			}
		}
		jsonobj.put("code", "-1");
		jsonobj.put("Msg", "没有登录");
		response.getWriter().print(jsonobj);
	}

}
