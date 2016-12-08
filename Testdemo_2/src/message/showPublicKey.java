package message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbclink.JdbcLink;

public class showPublicKey {
	public static String getPublicKey(String ID){
		Connection conn = JdbcLink.getConn();
		
		String publicKey = null;

		String selectInfoSql = "SELECT * FROM `userInfo` where ID="+ID+"";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(selectInfoSql);
			ResultSet result = ps.executeQuery();
			while (result.next()) 
            {
				publicKey = result.getString("publicKey");
            }
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publicKey;
	}
}
