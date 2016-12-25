package myservlet.control;

import mybean.data.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
//import javax.naming.*; 
import javax.naming.Context;
import javax.naming.InitialContext;

//import javax.naming.NamingException;  

public class HandleRegister extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
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
		
		DataSource ds = null;
		Context env = null;
		Connection con = null;
		PreparedStatement sql; // PreparedStatement 继承于 Statement
		Register reg = new Register(); // 定义一个新的 register 对象。

		request.setAttribute("register", reg); // 给 request 增加了一个属性
		String logname = request.getParameter("logname").trim(), password = request
				.getParameter("password").trim(), advertiseTitle = request
				.getParameter("advertiseTitle").trim(), email = request
				.getParameter("email").trim(), phone = request.getParameter(
				"phone").trim(), message = request.getParameter("message"); // 从
																			// request
																			// 中提取用户提交的信息
		if (logname == null)
			logname = "";
		if (password == null)
			password = "";
		boolean isLD = true;
		for (int i = 0; i < logname.length(); i++) // for 循环用来判断 logname
													// 中组成是不是字母和数字。这也是为什么上面
													// logname
													// 为"NULL",就给赋值为“”的原因，null
													// 代表指针所连接的值不存在，不存在是不能求长度的，会抛出无法解析的错误。
		{
			char c = logname.charAt(i);
			if (!((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0')))
				isLD = false;
		}
		boolean boo = logname.length() > 0 && password.length() > 0 && isLD; // 定义
																				// boo,当
																				// logname
																				// 和password
																				// 不为空，则
																				// boo
																				// 为
																				// 1.
		String backNews = "";
		try {
			System.out.println(System
					.getProperty("java.naming.factory.initial"));
			try {
				env = (Context) new InitialContext().lookup("java:comp/env");
				ds = (DataSource) env.lookup("jdbc/mysql");
				con = ds.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String insertCondition = "INSERT INTO member VALUES (?,?,?,?,?,?,?)";

			sql = con.prepareStatement(insertCondition);
			System.out.println(logname);
			System.out.println(password);
			System.out.println(advertiseTitle);
			if (boo) {
				sql.setString(1, handleString(logname));
				sql.setString(2, handleString(password));
				sql.setString(3, handleString(advertiseTitle));
				sql.setString(4, phone);
				sql.setString(5, email);
				sql.setString(6, handleString(message));
				sql.setString(7, "public.jpg");
				System.out.println(insertCondition);
				System.out.println("boo" + boo);

				int m = sql.executeUpdate();
				if (m != 0) {
					backNews = "注册成功";
					reg.setBackNews(backNews);
					reg.setLogname(logname);
					reg.setPassword(handleString(password));
					reg.setAdvertiseTitle(handleString(advertiseTitle));
					reg.setEmail(handleString(email));
					reg.setPhone(phone);
					reg.setMessage(handleString(message));
				}
			} else {
				backNews = "信息填写不完整或名字中有非法字符"; // 当 logname 信息不对
				reg.setBackNews(backNews);
			}
			con.close();
		}

		catch (SQLException exp) // 发生错误则设置backNews
		{
			backNews = "该会员名已被使用，请您更换名字" + exp;
			reg.setBackNews(backNews);
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("showRegisterMess.jsp");// 转发
		dispatcher.forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response); // 当采用 get 方式提交时，则还是要交个 doPost方法处理
	}
}
