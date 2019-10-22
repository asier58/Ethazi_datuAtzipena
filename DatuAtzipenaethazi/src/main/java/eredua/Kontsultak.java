package eredua;

import java.sql.ResultSet;
import java.sql.Statement;

public class Kontsultak {

	
	 String query = "SELECT * FROM users";

     // create the java statement
     Statement st = conn.createStatement();
     
     // execute the query, and get a java resultset
     ResultSet rs = st.executeQuery(query);
}
