package edu.xupt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.xupt.entity.InventoryBean;
import edu.xupt.util.JdbcUtil;

public class InventoryDao {

	private JdbcUtil jdbc = new JdbcUtil();

	public int insert(String user, String product, String sum) {

		Connection conn = jdbc.getConn();
		int result = 0;
		String sql = "insert into inventory(user,product,sum) value ('" + user
				+ "','" + product + "','" + sum + "')";

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
		String sql = "delete from inventory where id='" + id + "'";

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

	public int update(InventoryBean i) {

		Connection conn = jdbc.getConn();
		int result = 0;
		String sql = "update inventory set user=?,product=?,sum=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, i.getUser());
			ps.setString(2, i.getProduct());
			ps.setString(3, i.getSum());

			int id = Integer.parseInt(i.getId());
			ps.setInt(4, id);
			System.out.println(ps.toString());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public List<InventoryBean> selectAll() {
		Connection conn = jdbc.getConn();
		String sql = "select * from inventory";

		List<InventoryBean> inventory = new ArrayList<InventoryBean>();

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				InventoryBean inven = new InventoryBean();
				inven.setId(rs.getString(1));
				inven.setUser(rs.getString(2));
				inven.setProduct(rs.getString(3));
				inven.setSum(rs.getString(4));

				inventory.add(inven);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventory;
	}

}
