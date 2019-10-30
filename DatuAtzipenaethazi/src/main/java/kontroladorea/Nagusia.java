package kontroladorea;

import org.apache.log4j.Logger;
import lehioa.Departamentua;
import lehioa.Enplegatua;
import lehioa.Formularioa;
import lehioa.Menua;
import eredua.DBKonexioa;

public class Nagusia {

	public static Logger logger = Logger.getLogger(Nagusia.class);

	public static void main(String[] args) {

		/**
		 * Datu baserako konexioa
		 */

		String basedatos = "mydb";
		DBKonexioa con1 = new DBKonexioa();
		con1.conectarDB();
		
		eredua.Kontsultak.datuakSartu1(null);

//		eredua.Kontsultak.datuakSartu();
		eredua.Kontsultak.datuakBerritu();


		//ugadooooooooooooooooooooooooo
//		String basedatos = "mydb";
//		DBKonexioa con1 = new DBKonexioa();
//		con1.conectarDB();
		Menukontroladorea menukontroladorea = new Menukontroladorea();
		Departamentua departamentua = new Departamentua();
		Enplegatua enplegatua =  new Enplegatua();
		Formularioa formularioa = new Formularioa();

		// Lehioak
		Menua menua = new Menua();

		// ***********
		menukontroladorea.nireMenua(menua);
		menua.nireMenukontroladorea(menukontroladorea);
		// ***********
		menukontroladorea.nireDepartamentua(departamentua);
		departamentua.nireMenukontroladorea(menukontroladorea);

		//***********
		menukontroladorea.nireDepartamentua(enplegatua);
		enplegatua.nireMenukontroladorea(menukontroladorea);
		//********
		menukontroladorea.nireFormularioa(formularioa);
		formularioa.nireMenukontroladorea(menukontroladorea);
		
		ON(menua);
		
		

	}

	private static void ON(Menua menua) {
		menua.setVisible(true);
		logger.info("Programa Hasierati egin da");

	}

}
