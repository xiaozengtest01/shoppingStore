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
//		System.out.println( "����Login��");
		request.setCharacterEncoding("UTF-8");// ����ͳһ����!
		response.setContentType("text/html;charset=utf-8"); // 2
		response.setCharacterEncoding("utf-8");
		// ��ȡǰ�˵ĵ�����
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		JSONObject jsonobj = new JSONObject();
		HttpSession session = request.getSession(true);
		int flag;

		try {
			// �ж��û��������벻Ϊ��
			if (pwd == null || username == null) {
				jsonobj.put("code", "-2");
				jsonobj.put("Msg", "�˺Ż�����Ϊ��");
				response.getWriter().print(jsonobj);
			} else {
				// �������ݿ�
				flag = UserDao.login(username, pwd);
				if (flag == 0) {
					jsonobj.put("code", "-1");
					jsonobj.put("Msg", "�˺Ż��������");
					response.getWriter().print(jsonobj);
				} else {
					// û��cookie�ĵ�¼��������ȷ��ֵcookie��ԿҲ����sessionId
					System.out.println("����Login");
					Cookie cookie = new Cookie("Sid", session.getId());
					cookie.setHttpOnly(false);
					cookie.setPath("/");
					cookie.setMaxAge(60 * 60 * 7);
					response.addCookie(cookie);
					session.setMaxInactiveInterval(60 * 60 * 7);
					// cookie���õ�¼������
					Cookie userName = new Cookie("UserId", String.valueOf(flag));
					userName.setHttpOnly(false);
					userName.setPath("/");
//					userName.setDomain(pattern);
					userName.setMaxAge(60 * 60 * 7);
					response.addCookie(userName);
					jsonobj.put("code", "1");
					jsonobj.put("Msg", "��¼�ɹ�");
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
