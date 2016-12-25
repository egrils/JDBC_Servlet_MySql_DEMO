package myservlet.control;

import mybean.data.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HandleLogin extends HttpServlet {
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
		
		
		Connection con;
		PreparedStatement sql;
		Login loginBean = null;
		String backNews = "";
		HttpSession session = request.getSession(true);
		try {
			loginBean = (Login) session.getAttribute("login");
			if (loginBean == null) {
				loginBean = new Login();
				session.setAttribute("login", loginBean);
			}
		} catch (Exception ee) {
			loginBean = new Login();
			session.setAttribute("login", loginBean);
		}
		String logname = request.getParameter("logname").trim(), password = request
				.getParameter("password").trim();
		boolean ok = loginBean.getSuccess();
		logname = handleString(logname);
		password = handleString(password);
		if (ok == true && logname.equals(loginBean.getLogname())) {
			backNews = logname + "已经登录了";
			loginBean.setBackNews(backNews);
		} else {
			String uri = "jdbc:mysql://localhost:3306/friend?useUnicode=true&characterEncoding=utf-8";
			boolean boo = (logname.length() > 0) && (password.length() > 0);
			try {
				con = DriverManager.getConnection(uri, "root", "123456");
				String condition = "select * from member where logname =? and password =?";
				sql = con.prepareStatement(condition);
				if (boo) {
					sql.setString(1, logname);
					sql.setString(2, password);
					ResultSet rs = sql.executeQuery();
					boolean m = rs.next();
					if (m == true) {
						backNews = "登录成功";
						loginBean.setBackNews(backNews);
						loginBean.setSuccess(true);
						loginBean.setLogname(logname);
					} else {
						backNews = "您输入的用户名不存在，或密码不般配";
						loginBean.setBackNews(backNews);
						loginBean.setSuccess(false);
						loginBean.setLogname(logname);
						loginBean.setPassword(password);
					}
				} else {
					backNews = "您输入的用户名不存在，或密码不般配";
					loginBean.setBackNews(backNews);
					loginBean.setSuccess(false);
					loginBean.setLogname(logname);
					loginBean.setPassword(password);
				}
				con.close();
			} catch (SQLException exp) {
				backNews = "" + exp;
				loginBean.setBackNews(backNews);
				loginBean.setSuccess(false);
			}
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("showLoginMess.jsp");
		dispatcher.forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}