package kontroladorea;

import org.apache.log4j.Logger;
import lehioa.Departamentua;
import lehioa.Menua;
import eredua.DBKonexioa;

public class Nagusia {

	public static Logger logger = Logger.getLogger(Nagusia.class);

	public static void main(String[] args) {

		/**
		 * Datu baserako konexioa
		 */
		//ugadooooooooooooooooooooooooo
//		String basedatos = "mydb";
//		DBKonexioa con1 = new DBKonexioa();
//		con1.conectarDB();
		Menukontroladorea menukontroladorea = new Menukontroladorea();
		Departamentua departamentua = new Departamentua();
		// Lehioak
		Menua menua = new Menua();

		// ***********
		menukontroladorea.nireMenua(menua);
		menua.nireMenukontroladorea(menukontroladorea);
		// ***********
		menukontroladorea.nireDepartamentua(departamentua);
		departamentua.nireMenukontroladorea(menukontroladorea);

		ON(menua);
		
		

	}

	private static void ON(Menua menua) {
		menua.setVisible(true);
		logger.info("Programa Hasierati egin da");

	}

}
