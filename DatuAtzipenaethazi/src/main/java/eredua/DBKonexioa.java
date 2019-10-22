package eredua;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBKonexioa {
	
	public DBKonexioa() {
		
	}

	public void conectarDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			System.out.print("Database is connected!\n");
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.print("Do not connect to DB - Error:" + e);
		} catch (SQLException e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}
}