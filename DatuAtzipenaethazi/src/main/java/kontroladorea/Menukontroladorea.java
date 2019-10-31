package kontroladorea;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import eredua.Kontsultak;
import eredua.langilea;
import lehioa.Departamentua;
import lehioa.Enplegatua;
import lehioa.Formularioa;
import lehioa.Menua;

public class Menukontroladorea {
	public static Logger logger = Logger.getLogger(Menukontroladorea.class);
	private Menua menua;
	private Departamentua departamentua;
	private Enplegatua enplegatua;

	private Formularioa formularioa;

	public void nireMenua(Menua menua) {
		this.menua = menua;

	}

	public void nireDepartamentua(Departamentua departamentua) {
		this.departamentua = departamentua;

	}

	public void nireDepartamentua(Enplegatua enplegatua) {
		this.enplegatua = enplegatua;

	}
	public void nireFormularioa(Formularioa formularioa) {
		this.formularioa = formularioa;

	}


	// *************************
	// Departamentua Pantaila
	public void departamentuaPantailara() {
		menua.setVisible(false);
		departamentua.setVisible(true);
	}

	public void langilePantailara() {
		menua.setVisible(false);
		enplegatua.setVisible(true);
	}
	public void formularioPantailara() {
		enplegatua.setVisible(false);
		formularioa.setVisible(true);
	}

	public void parametroakHartu(String fitxategi, String formatua) {
		File fitx = new File(fitxategi + formatua);
		if (!fitx.exists()) {
			logger.error("Fitxategia ez da existitzen");
			departamentua.erroreaAtera();
		}

		else {

			if (formatua.equalsIgnoreCase(".txt")) {
				eredua.departamentua.txtKudeatu(fitxategi, formatua);
			}

			if (formatua.equalsIgnoreCase(".xml")) {
				eredua.departamentua.xmlKudeatu(fitxategi, formatua);
			}

			if (formatua.equalsIgnoreCase(".csv")) {
				eredua.departamentua.csvkudeatu(fitxategi, formatua);
			}
		}
	}

	public void parametroakHartu2(String fitxategi, String formatua) {
		File fitx = new File(fitxategi + formatua);
		if (!fitx.exists()) {
			logger.error("Fitxategia ez da existitzen");
			departamentua.erroreaAtera();
		}

		else {

			if (formatua.equalsIgnoreCase(".txt")) {
				eredua.langilea.txtKudeatu2(fitxategi, formatua);
			}

			
			if(formatua.equalsIgnoreCase(".xml")) {
				eredua.langilea.xmlKudeatu2(fitxategi,formatua);
				}

			if (formatua.equalsIgnoreCase(".csv")) {
				eredua.langilea.csvkudeatu2(fitxategi, formatua);
			}
		}

	}
	
	public void getData(ArrayList<langilea> arrayList) {
		Kontsultak.datuakSartu2(arrayList);
	}

	public void departamentutikMenura() {
		departamentua.setVisible(false);
		menua.setVisible(true);
		
	}
	public void langiletikMenura() {
		enplegatua.setVisible(false);
		menua.setVisible(true);
		
	}

}