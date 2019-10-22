package eredua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Kontsultak {
     
     public static void datuakSartu() {
 		Connection conexion = null;
 		Statement s = null;

 		try {
 			// Cargar el driver
 			Class.forName("com.mysql.jdbc.Driver");
 			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
 			s = (Statement) conexion.createStatement();

 			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

 			ResultSet rs = ((java.sql.Statement) s).executeQuery(
 					"INSERT INTO enplegatua (Kodea,Soldata) VALUES (0001,2000)");
// 			while (rs.next()) {
//
// 				izena = rs.getString(1);
// 				hotelak.add(izena);
//
// 			}
// 			for (String k : hotelak) {
// 				System.out.println(k);
// 			}
 		} catch (Exception e) {
 			System.out.println(e.getMessage());
 			System.out.println("jajanotira");
 		}
// 		return hotelak;
 	}
 	

}



