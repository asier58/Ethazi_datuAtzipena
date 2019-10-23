package eredua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Kontsultak {

	public static void datuakSartu1(ArrayList<departamentua> zerrenda) {
		Connection conexion = null;
		Statement s = null;

		try {

			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta

			String sql = "INSERT INTO `departamentua` (dept_no, izena, eraikina, zentroa) VALUES (?, ?, ?, ?)";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			preparedStatement.setInt(1, 01);
			preparedStatement.setString(2, "Informatika");
			preparedStatement.setInt(3, 02);
			preparedStatement.setString(4, "Elorrieta");

			int sartuTaulara = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("jajanotira");
		} 
	}
	
	public static void datuakBerritu() {
		Connection conexion = null;
		Statement s = null;

		try {

			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta

			String sql = "UPDATE `departamentua` set dept_no=?, izena=?, eraikina=?, zentroa=?";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			preparedStatement.setInt(1, 02);
			preparedStatement.setString(2, "Kimika");
			preparedStatement.setInt(3, 04);
			preparedStatement.setString(4, "Elorrieta");

			int sartuTaulara = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("jajanotira");
		} 
	}
}
