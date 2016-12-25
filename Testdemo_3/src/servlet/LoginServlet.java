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
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import DDA.MD5Coder;
import DDA.SHACoder;

import jdbclink.JdbcLink;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		Connection conn = JdbcLink.getConn();
		Boolean isUser = false; 
		
		String ID = request.getParameter("userName");
		String password = request.getParameter("password");
		String newEncodePas = null;
		
		String publicKey = null;
		String DDA = null;
		String encodePas = null;
		
		// 如果不存在 session 会话，则创建一个 session 对象
		HttpSession session = request.getSession(true);
         
		
		String selectInfoSql = "SELECT * FROM `userInfo` where ID="+ID+"";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(selectInfoSql);
			ResultSet result = ps.executeQuery();
			while (result.next()) 
            {
				encodePas = result.getString("password");
				publicKey = result.getString("publicKey");
				DDA = result.getString("DDA"); 

				if(DDA.equals("MD5")){
					byte[] bytePas = MD5Coder.encodeMD5(password);
					newEncodePas = Base64.encodeBase64String(bytePas);
					}
				if(DDA.equals("SHA")){
					byte[] bytePas = SHACoder.encodeSHA(password.getBytes());
					newEncodePas = Base64.encodeBase64String(bytePas);
					} 
				
				if(encodePas.equals(newEncodePas)){
					isUser = true;
				}
				
				if(isUser){
					response.sendRedirect("./show.jsp");
					String userIDKey = new String("ID");
					session.setAttribute(userIDKey, ID);
				}else{
					out.println ("<h1>用户名或密码错误,请重新输入</h1>");
					response.setHeader("Refresh","1;url=./login.jsp"); 
				}
            }
			
			out.println ("<h1>用户名不存在,请注册后登录</h1>");
			response.setHeader("Refresh","1;url=./register.jsp"); 
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
