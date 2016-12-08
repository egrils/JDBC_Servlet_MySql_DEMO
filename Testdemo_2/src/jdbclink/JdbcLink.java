package jdbclink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcLink {
    //URL
public static Connection getConn(){
	Connection conn=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8");
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

}
