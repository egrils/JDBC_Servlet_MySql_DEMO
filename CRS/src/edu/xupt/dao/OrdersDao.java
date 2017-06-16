package edu.xupt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.xupt.entity.OrderBean;
import edu.xupt.util.JdbcUtil;

public class OrdersDao {

	private JdbcUtil jdbc = new JdbcUtil();

	public int insert(String name, String product, String number) {

		Connection conn = jdbc.getConn();
		int result = 0;
		String sql = "insert into orders(user,product,number) value ('" + name
				+ "','" + product + "','" + number + "')";
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

	public int delete(String id) {

		Connection conn = jdbc.getConn();
		int result = 0;
		String sql = "delete from orders where id='" + id + "'";

		try {
			Statement st = conn.createStatement();
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int update(OrderBean o) {

		Connection conn = jdbc.getConn();
		int result = 0;
		String sql = "update orders set user=?,product=?,number=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, o.getUser());
			ps.setString(2, o.getProduct());
			ps.setString(3, o.getNumber());

			int id = Integer.parseInt(o.getId());
			ps.setInt(4, id);
			System.out.println(ps.toString());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public List<OrderBean> selectAll() {
		Connection conn = jdbc.getConn();
		String sql = "select * from orders";

		List<OrderBean> or = new ArrayList<OrderBean>();

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				OrderBean orde = new OrderBean();
				orde.setId(rs.getString(1));
				orde.setUser(rs.getString(2));
				orde.setProduct(rs.getString(3));
				orde.setNumber(rs.getString(4));
				or.add(orde);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return or;
	}

	public static void main(String[] args) {
		OrdersDao or = new OrdersDao();
		or.insert("wangmei", "we", "12");
	}

}
