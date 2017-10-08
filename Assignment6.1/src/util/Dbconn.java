package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {

	public Dbconn() {
	}

	public Connection createDbConnection() {
		String url = "jdbc:mysql://localhost:3306/survey_info";
		String user = "Jay";
		String passwd = "P@ss1234";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("SQL Connection Exception occured at DBConn" + ex);
		}
		return con;
	}

}
