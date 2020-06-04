import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDatabase {
	
	public Connection connetti() {
		Connection conn = null;
		String url = "jdbc:postgresql://IPAddress/DBname";
		String user = "username";
		String password = "password";
		try {
			conn = DriverManager.getConnection(url,user,password);
			if(conn!=null) {
				System.out.println("Connection successfully created");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public Connection connetti(String user, String password) {
		Connection conn = null;
		String url = "jdbc:postgresql://127.0.0.1/";
		try {
			conn = DriverManager.getConnection(url,user,password);
			if(conn!=null) {
				System.out.println("Connection successfully created");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}

