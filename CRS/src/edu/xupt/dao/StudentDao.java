package edu.xupt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.xupt.entity.UserBean;
import edu.xupt.util.JdbcUtil;

public class StudentDao {

	private JdbcUtil jdbc = new JdbcUtil();

	public int insert(String name, String password) {

		Connection conn = jdbc.getConn();
		int result = 0;
		String sql = "insert into students(name,password) value ('" + name
				+ "','" + password + "')";
		System.out.println(sql);
		Statement st;
		try {
			st = conn.createStatement();
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int deleteById(String id) {
		int result = 0;
		Connection conn = jdbc.getConn();
		String sql = "delete from students where id='" + id + "'";
		System.out.println(sql);
		Statement st;
		try {
			st = conn.createStatement();
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int update(UserBean u) {
		Connection conn = jdbc.getConn();
		int result = 0;
		String sql = "update students set name=?,password=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());

			int id = Integer.parseInt(u.getId());
			ps.setInt(3, id);
			System.out.println(ps.toString());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public String selectByUserName(String username) {
		Connection conn = jdbc.getConn();
		String password = "";
		String sql = "select * from students where name='" + username + "'";
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				password = rs.getString(3);
				// System.out.print(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

	public List<UserBean> selectAll() {
		Connection conn = jdbc.getConn();
		String sql = "select * from students";

		List<UserBean> users = new ArrayList<UserBean>();

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				UserBean user = new UserBean();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));

				System.out.print(rs.getString(1));
				System.out.print("-");
				System.out.print(rs.getString(2));
				System.out.print("-");
				System.out.print(rs.getString(3));
				System.out.println();
				users.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public static void main(String[] args) {
		StudentDao stu = new StudentDao();
		stu.selectAll();
	}
}
