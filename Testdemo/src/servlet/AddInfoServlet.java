package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import DDA.MD5Coder;
import DDA.SHACoder;

import jdbclink.JdbcLink;

public class AddInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddInfoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
//		JdbcLink test = new JdbcLink();
		Connection conn = JdbcLink.getConn();
		String ID = request.getParameter("userName");
		String password = request.getParameter("password");
		String publicKey = request.getParameter("publickey");
		String DDA = request.getParameter("dda");
		String ACA = request.getParameter("aca");
		String encodePas = null;
		try {
			System.out.println("DDA "+DDA);
			if(DDA.equals("MD5")){
				byte[] bytePas = MD5Coder.encodeMD5(password);
				encodePas = Base64.encodeBase64String(bytePas);
			}
			if(DDA.equals("SHA")){
				byte[] bytePas = SHACoder.encodeSHA(password.getBytes());
				encodePas = Base64.encodeBase64String(bytePas);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("ID", ID);
		
		String addInfoSql = "insert into userInfo(ID,password,publicKey,DDA,ACA)value('"
				+ ID
				+ "','"
				+ encodePas
				+ "','"
				+ publicKey
				+ "','"
				+ DDA
				+ "','" + ACA + "')";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(addInfoSql);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		out.println ("<h1>恭喜你注册成功！3秒后自动跳转</h1>");
		response.setHeader("Refresh","3;url=./show.jsp"); 
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
