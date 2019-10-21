package kontroladorea;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import eredua.DBKonexioa;
import lehioa.Departamentua;
import lehioa.Menua;

public class Nagusia {
	
	public static Logger logger = Logger.getLogger(Nagusia.class);
	public static void main(String[] args) {
	
		/**
		 * Datu baserako konexioa
		 */
		String basedatos = "mydb";
		DBKonexioa con1 = new DBKonexioa();
		con1.conectarMySQL();
		
	Menukontroladorea menukontroladorea =  new Menukontroladorea();
	Departamentua departamentua =  new Departamentua();
		//Lehioak
		Menua menua = new Menua();
		
		
		//***********
		menukontroladorea.nireMenua(menua);
		menua.nireMenukontroladorea(menukontroladorea);
		//***********
		menukontroladorea.nireDepartamentua(departamentua);
		departamentua.nireMenukontroladorea(menukontroladorea);
		
		ON(menua);

	}

	private static void ON(Menua menua) {
		menua.setVisible(true);
		logger.info("Programa Hasierati egin da");
		
	}

}
