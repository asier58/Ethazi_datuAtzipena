package kontroladorea;

import org.apache.log4j.Logger;

import eredua.DBKonexioa;
import lehioa.Departamentua;
import lehioa.Enplegatua;
import lehioa.Formularioa;
import lehioa.Formularioa2;
import lehioa.Menua;
import lehioa.deptTxostena;
import lehioa.langTxostena;

public class Nagusia {

	public static Logger logger;

	public static void main(String[] args) {
		logger = Logger.getLogger(Nagusia.class);
		/**
		 * Datu baserako konexioa
		 */

		String basedatos = "mydb";
		DBKonexioa con1 = new DBKonexioa();
		con1.conectarDB();
		
//		eredua.Kontsultak.datuakSartu1(null);
//
////		eredua.Kontsultak.datuakSartu();
//		eredua.Kontsultak.datuakBerritu();

		Menukontroladorea menukontroladorea = new Menukontroladorea();
		Departamentua departamentua = new Departamentua();
		Enplegatua enplegatua =  new Enplegatua();
		Formularioa formularioa = new Formularioa();
		Formularioa2 formularioa2 = new Formularioa2();
		deptTxostena depttxostena = new deptTxostena();
		langTxostena langtxostena = new langTxostena();

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
		//******
		menukontroladorea.nireFormularioa2(formularioa2);
		formularioa2.nireMenukontroladorea(menukontroladorea);
		//****
		menukontroladorea.nireTxostena1(depttxostena);
		depttxostena.nireMenukontroladorea(menukontroladorea);
		//***
		menukontroladorea.nireTxostena(langtxostena);
		langtxostena.nireMenukontroladorea(menukontroladorea);
		
		ON(menua);
		
		

	}

	private static void ON(Menua menua) {
		menua.setVisible(true);
		logger.info("Programa Hasierati egin da");

	}

}
