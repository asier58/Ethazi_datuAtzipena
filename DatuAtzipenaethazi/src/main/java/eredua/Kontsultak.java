package eredua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import kontroladorea.Menukontroladorea;

public class Kontsultak {
	public static Logger logger = Logger.getLogger(Kontsultak.class);
	/**
	 * INSERT
	 */
	// Departamentuen datu berriak sartzeko.
	public static void datuakSartu(ArrayList<departamentua> zerrenda) {
		Connection conexion = null;
		Statement s = null;
		for (departamentua k : zerrenda) {
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
				preparedStatement.setInt(1, k.getDept_no());
				preparedStatement.setString(2, k.getIzena());
				preparedStatement.setString(3, k.getEraikina());
				preparedStatement.setString(4, k.getZentroa());

				int sartuTaulara = preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("jajanotira");

			}

		}
	}

	public static void datuakSartu1(ArrayList<departamentua> zerrenda) {
		Connection conexion = null;
		Statement s = null;
		for (departamentua k : zerrenda) {
			try {

				// Cargar el driver
				Class.forName("com.mysql.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
				s = (Statement) conexion.createStatement();

				// Se realiza la consulta

				String sql = "INSERT INTO `departamentua` (dept_no, izena, eraikina, zentroa) VALUES (?, ?, ?, ?)";

				PreparedStatement preparedStatement = conexion.prepareStatement(sql);

				preparedStatement.setInt(1, zerrenda.get(0).getDept_no());
				preparedStatement.setString(2, zerrenda.get(0).getIzena());
				preparedStatement.setString(3, zerrenda.get(0).getEraikina());
				preparedStatement.setString(4, zerrenda.get(0).getZentroa());

				int sartuTaulara = preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("jajanotira");
			}
		}
	}

	// Enplegatuen datu berriak sarzeko.
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

			preparedStatement.setInt(1, zerrenda.get(0).getLangile_kod());
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
		}
	}

	/**
	 * UPDATE
	 */
	// Departamentuen datuak berritzeko.
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

	public static void datuakBerritu1() { // Enplegatuen datuak berritzeko.
		Connection conexion = null;
		Statement s = null;

		try {

			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta

			String sql = "UPDATE `enplegatua` set Kodea = ?, Departamentua_dept_no = ?, Soldata = ?, Izena = ?, Abizena = ?, Nagusia = ?, Ardura = ?, DataOrdua = ?";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			preparedStatement.setInt(1, 02);
			preparedStatement.setInt(2, 01);
			preparedStatement.setInt(3, 2000);
			preparedStatement.setString(4, "Paco");
			preparedStatement.setString(5, "Perez");
			preparedStatement.setInt(6, 02);
			preparedStatement.setString(7, "Irakasle");
			preparedStatement.setString(8, "2019/10/29");

			int sartuTaulara = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("jajanotira");
		}
	}

	// Departamentuko datuak hutsik sartzeko. Berritzen dugu 0ak edo espazio hutsak
	// sartuz.
	public static void datuakHustu() {
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

			preparedStatement.setInt(1, 00);
			preparedStatement.setString(2, "");
			preparedStatement.setInt(3, 00);
			preparedStatement.setString(4, "");

			int sartuTaulara = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("jajanotira");
		}
	}

	public static void datuakHustu1() {
		Connection conexion = null;
		Statement s = null;

		try {

			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta

			String sql = "UPDATE `enplegatua` set kodea = ?, izena = ?, abizena = ?, soldata = ?, departamentua_dept_no = ?, ardura = ?, nagusia = ?, DataOrdua = ?";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			preparedStatement.setInt(1, 00);
			preparedStatement.setString(2, "");
			preparedStatement.setString(3, "");
			preparedStatement.setInt(4, 00);
			preparedStatement.setInt(5, 00);
			preparedStatement.setString(6, "");
			preparedStatement.setString(7, "");
			preparedStatement.setString(8, "");

			int sartuTaulara = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("jajanotira");
		}
	}

	/**
	 * SELECT
	 */

	public static void datuakEskatu(ArrayList<langilea> zerrenda) {
		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT * FROM enplegatua WHERE izena = Ramon";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			int id = resultSet.getInt("Kodea");
			String izena = resultSet.getString("Izena");
			int departamentua_dept_no = resultSet.getInt("Departamentua_dept_no");
			int soldata = resultSet.getInt("Soldata");
			String abizena = resultSet.getString("Abizena");
			String ardura = resultSet.getString("Ardura");
			int nagusia = resultSet.getInt("Nagusia");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * DELETE
	 */
	
	public static void datuakEzabatu(ArrayList <langilea> zerrenda) {
		Connection conexion = null;
		Statement s = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();
			
			String sql = "DELETE FROM departamentua WHERE langile_kod = ?";
			
			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			preparedStatement.setInt(1, zerrenda.get(0).getLangile_kod());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//****Departamentu kudeaketa
	//***Departamentua
	public static int ateraZenbakiamaximoa() {
		int zenbakia =0;
		
		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT MAX(dept_no) FROM departamentua";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				zenbakia = resultSet.getInt(1);
				
			}

			
			
			

		} 
		
		catch(SQLException I) {
			logger.error(I.getMessage());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
		
		
		return zenbakia;
		
	}
	public static boolean depart_state(departamentua Dept) {
		boolean existitu = false;
		
		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = ("SELECT * FROM departamentua WHERE dept_no ="+Dept.getDept_no());

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.getRow()!=-1) {
				existitu=true;
			}

			
			
			

		} catch(SQLException I) {
			logger.error(I.getMessage());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
		
		return existitu;
	}
	public static int departamentuaEzabatuta(departamentua dept) {
		int zenbakia =58;
		Connection conexion = null;
		Statement s = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();
			
			String sql = "DELETE FROM departamentua WHERE dept_no = ?";
			
			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setInt(1, dept.getDept_no());
			//ResultSet resultSet = preparedStatement.executeQuery();
			zenbakia = preparedStatement.executeUpdate();
			
			
		}catch(SQLException I) {
			logger.error(I.getMessage());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
		
		return zenbakia;
	}
	public static int departamentuaAldatu(departamentua dept) {
		int zenbakia =58;
		Connection conexion = null;
		Statement s = null;

		try {

			
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();
			String sql = "UPDATE departamentua SET Izena=?, eraikina=?, zentroa=? WHERE dept_no=?";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			
			preparedStatement.setString(1, dept.getIzena());
			preparedStatement.setString(2, dept.getEraikina());
			preparedStatement.setString(3, dept.getZentroa());
			preparedStatement.setInt(4, dept.getDept_no());

			 zenbakia = preparedStatement.executeUpdate();
		}
			
			
		catch(SQLException I) {
			logger.error(I.getMessage());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
		
		return zenbakia;
	}
	//Departamentu Amaiera
	
	//***Enplegatua
	//Insert baino lehen kodea ateratzen dugu enplegatuari kode egokiena emateko
	public static int ateraEnplegatumaximoa() {
		int zenbakia =0;
		
		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT MAX(Kodea) FROM enplegatua";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				zenbakia = resultSet.getInt(1);
				
			}

			} 
		
		catch(SQLException I) {
			logger.error(I.getMessage());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
		
		
		return zenbakia;
		
	}
	//Enplegatua existitzen badu ikusten duen metodoa
	public static boolean enplegatu_state(langilea lang) {
		boolean existitu = false;
		
		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = ("SELECT * FROM enplegatua WHERE Kodea ="+lang.getLangile_kod());

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.getRow()!=-1) {
				existitu=true;
			}

			
			
			

		} catch(SQLException I) {
			logger.error(I.getMessage());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
		
		return existitu;
	}
	
	//**Enplegatu Amaiera
	//****
}
