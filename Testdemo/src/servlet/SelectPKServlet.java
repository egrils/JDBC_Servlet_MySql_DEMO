package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbclink.JdbcLink;

public class SelectPKServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectPKServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Connection conn = JdbcLink.getConn();
		
		String ID = request.getParameter("inputID");
		String publicKey = null;

		String selectInfoSql = "SELECT * FROM `userInfo` where ID="+ID+"";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(selectInfoSql);
			ResultSet result = ps.executeQuery();
			while (result.next()) 
            {
				publicKey = result.getString("publicKey");
				HttpSession session = request.getSession(true);
				session.setAttribute("publicKey", publicKey);
            }
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setHeader("Refresh","1;url=./show.jsp"); 
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


}
