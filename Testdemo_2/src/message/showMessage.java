package message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbclink.JdbcLink;

public class showMessage {
	public static String getMessage(String ID){
		Connection conn = JdbcLink.getConn();
		
		String message = null;

		String selectInfoSql = "SELECT * FROM `userInfo` where ID="+ID+"";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(selectInfoSql);
			ResultSet result = ps.executeQuery();
			while (result.next()) 
            {
				message = result.getString("message");
            }
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
