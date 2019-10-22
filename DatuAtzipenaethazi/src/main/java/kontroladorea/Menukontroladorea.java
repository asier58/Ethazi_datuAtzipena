package kontroladorea;

import java.io.BufferedWriter;
<<<<<<< Upstream, based on branch 'master' of https://github.com/asier58/Ethazi_datuAtzipena.git
=======

>>>>>>> 22d88e3 Departamentua txt y csv
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import lehioa.Departamentua;
import lehioa.Menua;

public class Menukontroladorea {
	public static Logger logger = Logger.getLogger(Menukontroladorea.class);
	private Menua menua;
<<<<<<< Upstream, based on branch 'master' of https://github.com/asier58/Ethazi_datuAtzipena.git
	private Departamentua departamentua;
<<<<<<< Upstream, based on branch 'master' of https://github.com/asier58/Ethazi_datuAtzipena.git
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Lehioak
	//Hasierako Pantaila
=======
=======
	private Departamentua departamentua;
>>>>>>> 22d88e3 Departamentua txt y csv

<<<<<<< Upstream, based on branch 'master' of https://github.com/asier58/Ethazi_datuAtzipena.git
	// Lehioak
	// Hasierako Pantaila
>>>>>>> ac2480d Datu baserako konexioa FINAL
=======
	//Lehioak
	//Hasierako Pantaila

>>>>>>> 22d88e3 Departamentua txt y csv
	public void nireMenua(Menua menua) {
		this.menua = menua;

	}

	public void nireDepartamentua(Departamentua departamentua) {
		this.departamentua = departamentua;

	}

	// *************************
	// Departamentua Pantaila
	public void departamentuaPantailara() {
		menua.setVisible(false);
		departamentua.setVisible(true);
	}

<<<<<<< Upstream, based on branch 'master' of https://github.com/asier58/Ethazi_datuAtzipena.git
<<<<<<< Upstream, based on branch 'master' of https://github.com/asier58/Ethazi_datuAtzipena.git
	public void parametroakHartu(String fitxategi, String formatua) {
		File fitx = new File(fitxategi+formatua);
		if (!fitx.exists()) {
			logger.error("Fitxategia ez da existitzen");
			departamentua.erroreaAtera();
			}
		
		else {
			
			if(formatua.equalsIgnoreCase(".txt")) {
				eredua.departamentua.txtKudeatu(fitxategi,formatua);
			}
			
			if(formatua.equalsIgnoreCase(".xml")) {
				
			}
			
			if(formatua.equalsIgnoreCase(".csv")) {
				eredua.departamentua.csvkudeatu(fitxategi,formatua);
			}
			
				
			
			
			
			
			
			
			}
		}

	private void txtKudeatu(String fitxategi, String formatua) {
			
			
		}
	private void csvKudeatu(String fitxategi, String formatua) {
		
		
	}
	private void xmlKudeatu(String fitxategi, String formatua) {
		
		
	}
		
	}


















































	
	

=======
}
>>>>>>> ac2480d Datu baserako konexioa FINAL
=======



	public void parametroakHartu(String fitxategi, String formatua) {
		File fitx = new File(fitxategi+formatua);
		if (!fitx.exists()) {
			logger.error("Fitxategia ez da existitzen");
			departamentua.erroreaAtera();
			}
		
		else {
			
			if(formatua.equalsIgnoreCase(".txt")) {
				eredua.departamentua.txtKudeatu(fitxategi,formatua);
			}
			
			if(formatua.equalsIgnoreCase(".xml")) {
				
			}
			
			if(formatua.equalsIgnoreCase(".csv")) {
				eredua.departamentua.csvkudeatu(fitxategi,formatua);
			}
			
				
			
			
			
			
			
			
			}
		}

	private void txtKudeatu(String fitxategi, String formatua) {
			
			
		}
	private void csvKudeatu(String fitxategi, String formatua) {
		
		
	}
	private void xmlKudeatu(String fitxategi, String formatua) {
		
		
	}
		
	}


















































	
	

>>>>>>> 22d88e3 Departamentua txt y csv
