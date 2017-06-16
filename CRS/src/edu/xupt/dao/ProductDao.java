package edu.xupt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.xupt.entity.ProductBean;
import edu.xupt.util.JdbcUtil;

public class ProductDao {

	private JdbcUtil jdbc = new JdbcUtil();

	public int insert(String name, String type, String description) {
		Connection conn = jdbc.getConn();
		int result = 0;
		String sql = "insert into products(name,type,description) value ('"
				+ name + "','" + type + "','" + description + "')";
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
		String sql = "delete from products where id='" + id + "'";

		try {
			Statement st = conn.createStatement();
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int update(ProductBean p) {

		Connection conn = jdbc.getConn();
		int result = 0;
		String sql = "update products set name=?,type=?,description=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getType());
			ps.setString(3, p.getDescription());

			int id = Integer.parseInt(p.getId());
			ps.setInt(4, id);
			System.out.println(ps.toString());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public List<ProductBean> selectAll() {
		Connection conn = jdbc.getConn();
		String sql = "select * from products";

		List<ProductBean> pro = new ArrayList<ProductBean>();

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				ProductBean prod = new ProductBean();
				prod.setId(rs.getString(1));
				prod.setName(rs.getString(2));
				prod.setType(rs.getString(3));
				prod.setDescription(rs.getString(4));
				pro.add(prod);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}

	public static void main(String[] args) {
		ProductDao pro = new ProductDao();

		pro.insert("sandwich", "food", "tastes good");
	}
}
