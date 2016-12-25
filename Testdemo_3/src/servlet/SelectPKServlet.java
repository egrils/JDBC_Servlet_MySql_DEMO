package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = JdbcLink.getConn();
		
		String ID = request.getParameter("inputID");
		String publicKey = null;
		
		if(ID.equals(null)||ID.equals("")||ID.equals("请输入对方ID")){
			out.write("请输入用户ID");
		}else{
			
		String selectInfoSql = "SELECT * FROM `userInfo` where ID="+ID+"";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(selectInfoSql);
			ResultSet result = ps.executeQuery();
			while (result.next()) 
            {
				publicKey = result.getString("publicKey");
				out.write(publicKey);
            }
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}


}
