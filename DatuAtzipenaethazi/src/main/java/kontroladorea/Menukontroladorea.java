package kontroladorea;

import java.io.BufferedWriter;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import lehioa.Departamentua;
import lehioa.Menua;

public class Menukontroladorea {
	public static Logger logger = Logger.getLogger(Menukontroladorea.class);
	private Menua menua;
	private Departamentua departamentua;

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


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
			}}
		}


		
	


















































	
	


}



	

	
		
	


















































	
	


