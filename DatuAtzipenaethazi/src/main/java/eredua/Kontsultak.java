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
		for(departamentua k : zerrenda) {
		try {

			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta

			String sql = "INSERT INTO `departamentua` (dept_no, izena, eraikina, zentroa) VALUES (?, ?, ?, ?)";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			preparedStatement.setInt(1, k.getDept_no());
			preparedStatement.setString(2, k.getIzena());
			preparedStatement.setString(3, k.getEraikina());
			preparedStatement.setString(4, k.getZentroa());

			int sartuTaulara = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("jajanotira");
		} }
	}
	
	public static void datuakSartu2(ArrayList<langilea> zerrenda) {
		Connection conexion = null;
		Statement s = null;

		try {

			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta

			String sql = "INSERT INTO `enplegatua` (Kodea, Departamentua_dept_no, Soldata, Izena, Abizena,Nagusia,Ardura,DataOrdua) VALUES (?, ?, ?, ?,?, ?, ?, ?)";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			preparedStatement.setInt(1,  zerrenda.get(0).getLangile_kod());
			preparedStatement.setInt(2, zerrenda.get(0).getDept_nozenbakia());
			preparedStatement.setDouble(3, zerrenda.get(0).getSoldata());
			preparedStatement.setString(4, zerrenda.get(0).getIzena());
			preparedStatement.setString(5, zerrenda.get(0).getAbizena());
			preparedStatement.setInt(6, zerrenda.get(0).getNagusia());
			preparedStatement.setString(7, zerrenda.get(0).getArdura());
			preparedStatement.setString(8, zerrenda.get(0).getDataOrdua());

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
