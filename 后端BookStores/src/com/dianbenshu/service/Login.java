package com.dianbenshu.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.dianbenshu.dao.UserDao;
import com.dianbenshu.entiy.User;

/**
 * Servlet implementation class login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
//		System.out.println( "这是Login！");
		request.setCharacterEncoding("UTF-8");// 处理统一编码!
		response.setContentType("text/html;charset=utf-8"); // 2
		response.setCharacterEncoding("utf-8");
		// 获取前端的的数据
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		JSONObject jsonobj = new JSONObject();
		HttpSession session = request.getSession(true);
		int flag;

		try {
			// 判断用户名和密码不为空
			if (pwd == null || username == null) {
				jsonobj.put("code", "-2");
				jsonobj.put("Msg", "账号或密码为空");
				response.getWriter().print(jsonobj);
			} else {
				// 访问数据库
				flag = UserDao.login(username, pwd);
				if (flag == 0) {
					jsonobj.put("code", "-1");
					jsonobj.put("Msg", "账号或密码错误");
					response.getWriter().print(jsonobj);
				} else {
					// 没有cookie的登录，密码正确赋值cookie秘钥也就是sessionId
					System.out.println("我是Login");
					Cookie cookie = new Cookie("Sid", session.getId());
					cookie.setHttpOnly(false);
					cookie.setPath("/");
					cookie.setMaxAge(60 * 60 * 7);
					response.addCookie(cookie);
					session.setMaxInactiveInterval(60 * 60 * 7);
					// cookie设置登录后的身份
					Cookie userName = new Cookie("UserId", String.valueOf(flag));
					userName.setHttpOnly(false);
					userName.setPath("/");
//					userName.setDomain(pattern);
					userName.setMaxAge(60 * 60 * 7);
					response.addCookie(userName);
					jsonobj.put("code", "1");
					jsonobj.put("Msg", "登录成功");
					response.getWriter().print(jsonobj);
					// response.getWriter().print(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
