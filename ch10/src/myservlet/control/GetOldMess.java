package myservlet.control;

import mybean.data.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetOldMess extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
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
			continueWork(request, response);
		}
	}

	public void continueWork(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Login login = (Login) session.getAttribute("login");
		Connection con = null;
		String logname = login.getLogname();
		Register register = new Register();
		request.setAttribute("register", register);
		String uri = "jdbc:mysql://localhost:3306/friend?useUnicode=true&characterEncoding=UTF-8";
		try {
			con = DriverManager.getConnection(uri, "root", "123456");

			Statement sql = con.createStatement();
			ResultSet rs = sql
					.executeQuery("SELECT * FROM member where logname='"
							+ logname + "'");
			if (rs.next()) {
				register.setLogname(rs.getString(1));
				register.setAdvertiseTitle(rs.getString(3));
				register.setPhone(rs.getString(4));
				register.setEmail(rs.getString(5));
				register.setMessage(rs.getString(6));
				register.setBackNews("您原来的注册信息:");
			}
		} catch (SQLException exp) {
			register.setBackNews("" + exp);
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("inputModifyMess.jsp");// 转发
		dispatcher.forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}