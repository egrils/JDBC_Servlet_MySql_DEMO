package edu.xupt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// param1:
			// param2: username
			// param
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/recommenderdb", "root",
						"123456");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		JdbcUtil jdbc = new JdbcUtil();
		Connection conn = jdbc.getConn();
		System.out.println(conn);
	}
}