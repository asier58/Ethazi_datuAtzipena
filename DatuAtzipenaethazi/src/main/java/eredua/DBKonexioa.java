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
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			System.out.print("Database is connected !");
			conn.close();
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}
}