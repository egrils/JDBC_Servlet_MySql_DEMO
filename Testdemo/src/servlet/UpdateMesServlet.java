package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbclink.JdbcLink;

public class UpdateMesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UpdateMesServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		Connection conn = JdbcLink.getConn();
		
		String ID = request.getParameter("friendID");
		String leaveMessage = request.getParameter("message");

		String updateInfoSql = "UPDATE `userInfo` SET message = '"+leaveMessage+"'where ID="+ID+"";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(updateInfoSql);
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setHeader("Refresh","1;url=./show.jsp"); 
	}


}
