package eredua;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.pattern.LogEvent;

import kontroladorea.Menukontroladorea;
import lehioa.Departamentua;
import lehioa.Enplegatua;
import lehioa.Formularioa;
import lehioa.Formularioa2;

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
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
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
				logger.error(e.getMessage());
				Departamentua.txertatuErrorea();
			}
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
	}

	// Enplegatuen datu berriak sarzeko.
	public static int datuakSartu2(langilea l1) { // la usa aitor
		// departamentu zenbakia datu basean ez bada existitzen ez INSERT-a egingo!!!
		Connection conexion = null;
		Statement s = null;
		int sartuTaulara = 0;

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta

			String sql = "INSERT INTO `enplegatua` (Kodea,Departamentua_dept_no,Soldata,Izena,Abizena,Nagusia,Ardura,DataOrdua) VALUES (?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			preparedStatement.setInt(1, l1.getLangile_kod());
			preparedStatement.setInt(2, l1.getDept_nozenbakia());
			preparedStatement.setDouble(3, l1.getSoldata());
			preparedStatement.setString(4, l1.getIzena());
			preparedStatement.setString(5, l1.getAbizena());
			preparedStatement.setInt(6, l1.getNagusia());
			preparedStatement.setString(7, l1.getArdura());
			preparedStatement.setString(8, l1.getDataOrdua());

			sartuTaulara = preparedStatement.executeUpdate();
			Formularioa.operazioa();

		} catch (SQLException n) {
			System.out.println(n.getMessage());
			logger.error(n.getErrorCode());
			Enplegatua.txertatuErrorea();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			logger.error(e.getMessage());
			Enplegatua.txertatuErrorea();
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return sartuTaulara;
		
		
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
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
	}

	public static void datuakBerritu1(langilea l1) { // Enplegatuen datuak berritzeko.
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

			preparedStatement.setInt(1, l1.getLangile_kod());
			preparedStatement.setInt(2, l1.getDept_nozenbakia());
			preparedStatement.setDouble(3, l1.getSoldata());
			preparedStatement.setString(4, l1.getIzena());
			preparedStatement.setString(5, l1.getAbizena());
			preparedStatement.setInt(6, l1.getNagusia());
			preparedStatement.setString(7, l1.getArdura());
			preparedStatement.setString(8, l1.getDataOrdua());

			int sartuTaulara = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
			Formularioa.txertatuErrorea();
		}
		
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
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
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
	}

	public static void datuakEguneratuBD(langilea l1) {
		Connection conexion = null;
		Statement s = null;
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		try {

			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta

			String sql = "UPDATE `enplegatua` set izena = ?, abizena = ?, soldata = ?, departamentua_dept_no = ?, ardura = ?, nagusia = ?, DataOrdua = ? WHERE Kodea = ?";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			preparedStatement.setInt(8, l1.getLangile_kod());
			preparedStatement.setString(1, l1.getIzena());
			preparedStatement.setString(2, l1.getAbizena());
			preparedStatement.setDouble(3, l1.getSoldata());
			preparedStatement.setInt(4, l1.getDept_nozenbakia());
			preparedStatement.setString(5, l1.getArdura());
			preparedStatement.setInt(6, l1.getNagusia());
			preparedStatement.setString(7, hourdateFormat.format(date));

			int sartuTaulara = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
	}

	/**
	 * SELECT
	 */

	
	public static ArrayList<String> arduraZuzendari(langilea l1) {
		Connection conexion = null;
		Statement s = null;
		ArrayList<String> arduraArr = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT Ardura FROM enplegatua WHERE Departamentua_dept_no = ? And Ardura LIKE ?";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			
			preparedStatement.setInt(1, l1.getDept_nozenbakia());
			preparedStatement.setString(2, "Zuzendari");

			ResultSet resultSet = preparedStatement.executeQuery();

			String ardura = resultSet.getString("Ardura");
			arduraArr.add(ardura);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			JOptionPane.showMessageDialog(null, e.getMessage(),"InfoBox",
//					JOptionPane.INFORMATION_MESSAGE);
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return arduraArr;
	}

	public static ArrayList<String> arduraIkasketaBurua(langilea l1) {
		Connection conexion = null;
		Statement s = null;
		ArrayList<String> arduraArr = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT Ardura FROM enplegatua WHERE Departamentua_dept_no = ? And Ardura LIKE ?";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			
			preparedStatement.setInt(1, l1.getDept_nozenbakia());
			preparedStatement.setString(2, "Irakasketa Burua");

			ResultSet resultSet = preparedStatement.executeQuery();

			String ardura = resultSet.getString("Ardura");
			arduraArr.add(ardura);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			JOptionPane.showMessageDialog(null, e.getMessage(),"InfoBox",
//					JOptionPane.INFORMATION_MESSAGE);
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return arduraArr;
	}
	/**
	 * DELETE
	 */

	public static void datuakEzabatu(ArrayList<langilea> zerrenda) {
//	public static void getLangile_kodBD(ArrayList<langilea> zerrenda, int kod) {
		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();
			String sql = "DELETE FROM departamentua WHERE langile_kod = ?";
//			String sql = "SELECT langile_kod FROM enplegatua WHERE langile_kod = '" + kod + "'";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.setInt(1, zerrenda.get(0).getLangile_kod());
			int id = resultSet.getInt("Kodea");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
	}

	// ****Departamentu kudeaketa
	// ***Departamentua
	public static ArrayList<departamentua> ateraDepartamentuak() {
		ArrayList<departamentua> zerrenda = new ArrayList<departamentua>();
		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT * FROM departamentua";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int dept_no = resultSet.getInt(1);
				String izena = resultSet.getString(2);
				String eraikina = resultSet.getString(3);
				String zentroa = resultSet.getString(4);

				departamentua Departamentua = new departamentua(dept_no, izena, eraikina, zentroa);
				zerrenda.add(Departamentua);

			}
			

		}

		catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return zerrenda;
	}

	public static int ateraZenbakiamaximoa() {
		int zenbakia = 0;

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

		catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return zenbakia;

	}

	public static int sartuDepartamentua(departamentua Dept) {
		int zenbakia = 0;
		ArrayList<String> departamentuak =  new ArrayList<String>();
		departamentuak = departamentuZerrenda();
		boolean existituta = false;
		for(int i=0;i<departamentuak.size();i++) {
			if (Dept.getIzena().equalsIgnoreCase(departamentuak.get(i))) {
				existituta = true;
				break;
			}
		}
		Connection conexion = null;
		Statement s = null;
		if(existituta==false) {
		try {

			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta

			String sql = "INSERT INTO `departamentua` (dept_no, izena, eraikina, zentroa) VALUES (?, ?, ?, ?)";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setInt(1, Dept.getDept_no());
			preparedStatement.setString(2, Dept.getIzena());
			preparedStatement.setString(3, Dept.getEraikina());
			preparedStatement.setString(4, Dept.getZentroa());
			zenbakia = preparedStatement.executeUpdate();

		} catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}}
		else {
			zenbakia=0;
		}

		return zenbakia;

	}
	
	private static ArrayList<String> departamentuZerrenda() {
		ArrayList<String> izenak = new ArrayList<String>();
		Connection conexion = null;
		Statement s = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = ("SELECT Izena FROM departamentua" );

			Statement statement = conexion.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				String hitza = result.getString(1);
				izenak.add(hitza);
				
				
				
			}

		} catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return izenak;
	}

	

	public static boolean depart_state(departamentua Dept) {
		boolean existitu = false;

		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = ("SELECT * FROM departamentua WHERE dept_no = " + Dept.getDept_no());

			Statement statement = conexion.createStatement();
			ResultSet result = statement.executeQuery(sql);

			int zenbakia = result.getRow();
			while (result.next()) {
				System.out.println(result.getInt(1));
				System.out.println(result.getString(2));
				existitu = true;
			}

		} catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}

		return existitu;
	}

	public static int departamentuaEzabatuta(departamentua dept) {
		int zenbakia = 58;
		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "DELETE FROM departamentua WHERE dept_no = ?";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setInt(1, dept.getDept_no());
			// ResultSet resultSet = preparedStatement.executeQuery();
			zenbakia = preparedStatement.executeUpdate();

		} catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}

		return zenbakia;
	}

	public static int departamentuaAldatu(departamentua dept) {
		int zenbakia = 58;
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

		catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return zenbakia;
	}
	// Departamentu Amaiera

	// ***Enplegatua
	// Insert baino lehen kodea ateratzen dugu enplegatuari kode egokiena emateko
	public static int ateraEnplegatumaximoa() {
		int zenbakia = 0;

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

		catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		
		return zenbakia;

	}
	
	public static ArrayList<Integer> ateraEnplegatuKod() {
		ArrayList<Integer> zenbakia = new ArrayList<Integer>();

		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
//			s = (Statement) conexion.createStatement();

			String sql = "SELECT Kodea FROM enplegatua";

			
			Statement statement = conexion.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				int kode = result.getInt(1);
					zenbakia.add(kode);	
			}

		}

		catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return zenbakia;

	}

	// Enplegatua existitzen badu ikusten duen metodoa
	public static boolean enplegatu_state(langilea lang) {
		boolean existitu = false;

		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = ("SELECT * FROM enplegatua WHERE Kodea =" + lang.getLangile_kod());

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				existitu = true;
			}

		} catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return existitu;
	}

	// Enplegatua ezabatzeko metodoa
	public static int enplegatuEzabatuta(langilea lang) {
		int zenbakia = 58;
		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "DELETE FROM enplegatua WHERE Kodea = ?";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setInt(1, lang.getLangile_kod());
			// ResultSet resultSet = preparedStatement.executeQuery();
			zenbakia = preparedStatement.executeUpdate();

		} catch (SQLException I) {
			logger.error(I.getMessage());
			Formularioa.ezabatuLangile();
		} catch (Exception e) {
			logger.error(e.getMessage());
			Formularioa.ezabatuLangile();
		}
		
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}

		return zenbakia;
	}

	public static int enplegatuaAldatu(langilea lang) {
		int zenbakia = 58;
		Connection conexion = null;
		Statement s = null;
		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String data = dateFormat.format(date).toString();
		String ordua = hourFormat.format(date).toString();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();
			String sql = "UPDATE enplegatua SET Departamentua_dept_no=?, Soldata=?, Izena=?, Abizena=?, Nagusia=?, Ardura=?, DataOrdua=? WHERE Kodea=?";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			preparedStatement.setInt(1, lang.getDept_nozenbakia());
			preparedStatement.setDouble(2, lang.getSoldata());
			preparedStatement.setString(3, lang.getIzena());
			preparedStatement.setString(4, lang.getAbizena());
			preparedStatement.setInt(5, lang.getNagusia());
			preparedStatement.setString(6, lang.getArdura());
			preparedStatement.setString(7, data + "," + ordua);
			preparedStatement.setInt(8, lang.getLangile_kod());
			zenbakia = preparedStatement.executeUpdate();
		}

		catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return zenbakia;
	}

	public static ArrayList<langilea> ateraLangileak() {
		ArrayList<langilea> zerrenda = new ArrayList<langilea>();
		Connection conexion = null;
		Statement s = null;
		int kodeaa = 0;
		int departamentuaa = 0;
		Double soldataa = 0.0;
		String izenaa = "";
		String abizenaa = "";
		int nagusiaa = 0;
		String Arduraa = "";
		String dataOrduaa = "";
		System.out.println();
		langilea Langileaa;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT * FROM enplegatua";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				kodeaa = resultSet.getInt(1);
				departamentuaa = resultSet.getInt(2);
				soldataa = resultSet.getDouble(3);
				izenaa = resultSet.getString(4);
				abizenaa = resultSet.getString(5);
				nagusiaa = resultSet.getInt(6);
				Arduraa = resultSet.getString(7);
				dataOrduaa = resultSet.getString(8);

				Langileaa = new langilea(kodeaa, departamentuaa, soldataa, izenaa, abizenaa, nagusiaa, Arduraa, dataOrduaa);
				zerrenda.add(Langileaa);

			}

		}

		
		catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		
		return zerrenda;
	}

	public static void getLangile_kodBD(ArrayList<langilea> zerrenda, int kod) {
		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT langile_kod FROM enplegatua WHERE langile_kod = '" + kod + "'";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			

			ResultSet resultSet = preparedStatement.executeQuery();

			int id = resultSet.getInt("Kodea");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
	}
	
	public static ArrayList<Integer> ateraLangile_Kod() {
		ArrayList<langilea> zerrenda = new ArrayList<langilea>();
		ArrayList<Integer> langileKodArrayList = new ArrayList<Integer>();
		Connection conexion = null;
		Statement s = null;
		int kodea = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT Kodea FROM enplegatua";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				kodea = resultSet.getInt(1);
				langileKodArrayList.add(kodea);
			}

		}

		catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}

		return langileKodArrayList;
	}

	// **Enplegatu Amaiera
	// ****
	public static int departamentuBurua(langilea lang) {
		int zenbakia = 0;
		Connection conexion = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT Ardura FROM enplegatua WHERE Departamentua_dept_no = ? And Ardura LIKE ?";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setInt(1, lang.getDept_nozenbakia());
			preparedStatement.setString(2, "Ikasketa burua");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				zenbakia++;
			}
		}
		catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return zenbakia;
	}

	public static int zuzendari(langilea l1) {
		int zenbakia = 0;
		Connection conexion = null;
		Statement s = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT * FROM departamentua WHERE dept_no = ? ";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setInt(1, l1.getDept_nozenbakia());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				zenbakia++;
			}
		}
		catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return zenbakia;
	
		
	}

	public static int zuzendariakAtera(langilea l1) {
		int zenbakia = 0;
		Connection conexion = null;
		Statement s = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			s = (Statement) conexion.createStatement();

			String sql = "SELECT * FROM enplegatua WHERE Ardura = ? ";

			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, l1.getArdura());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				zenbakia++;
			}
		}
		catch (SQLException I) {
			logger.error(I.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			conexion.close();
		}catch(SQLException SQ) {
			logger.error(SQ.getMessage());
		}
		return zenbakia;
	
		
		
	}
}
