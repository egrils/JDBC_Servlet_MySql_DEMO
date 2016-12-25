package myservlet.control;

import mybean.data.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HandleModifyMess extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
	}

	public String handleString(String s) {
		try {
//			byte bb[] = s.getBytes("ISO-8859-1");
//			s = new String(bb,"UTF-8");
			s = new String(s);
		} catch (Exception ee) {
		}
		return s;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession(true);
		Login login = (Login) session.getAttribute("login");// 获取用户登录时的Javabean
		boolean ok = true;
		if (login == null) {
			ok = false;
			response.sendRedirect("login.jsp"); // 重定向到登录页面
		}
		if (ok == true) {
			continueDoPost(request, response);
		}
	}

	public void continueDoPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(true);
		Login login = (Login) session.getAttribute("login");
		String logname = login.getLogname();
		
		Connection con;
		PreparedStatement sql;
		
		ModifyMessage modify = new ModifyMessage();
		request.setAttribute("modify", modify);
		String advertiseTitle = request.getParameter("newAdvertiseTitle")
				.trim(), email = request.getParameter("newEmail").trim(), phone = request
				.getParameter("newPhone").trim(), message = request
				.getParameter("newMessage");
		String uri = "jdbc:mysql://localhost:3306/friend?useUnicode=true&characterEncoding=utf-8";
		String backNews = "";
		try {
			con = DriverManager.getConnection(uri, "root", "123456");
			String updateCondition = "UPDATE member SET advertiseTitle=?,phone=?,email=?,message=? WHERE logname=?";
			sql = con.prepareStatement(updateCondition);
			sql.setString(1, handleString(advertiseTitle));
			sql.setString(2, phone);
			sql.setString(3, handleString(email));
			sql.setString(4, handleString(message));
			sql.setString(5, logname);
			int m = sql.executeUpdate();
			if (m == 1) {
				backNews = "修改信息成功";
				modify.setBackNews(backNews);
				modify.setLogname(logname);
				modify.setNewAdvertiseTitle(handleString(advertiseTitle));
				modify.setNewEmail(handleString(email));
				modify.setNewPhone(phone);
				modify.setNewMessage(handleString(message));
			} else {
				backNews = "信息填写不完整或信息中有非法字符";
				modify.setBackNews(backNews);
			}
			con.close();
		} catch (SQLException exp) {
			modify.setBackNews("" + exp);
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("showModifyMess.jsp");// 转发
		dispatcher.forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}