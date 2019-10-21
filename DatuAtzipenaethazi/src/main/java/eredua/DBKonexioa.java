package eredua;

import java.sql.Connection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DBKonexioa {
	public static Logger logger = Logger.getLogger(DBKonexioa.class);
	 // Librería de MySQL
    public String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "mydb";
    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
//    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    public String url = "org.mariadb.jdbc";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(" Conectado a la Base de datos  ");
            logger.info("enchufa");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            logger.info("no enchufa");
        }

        return conn;
    }


}
