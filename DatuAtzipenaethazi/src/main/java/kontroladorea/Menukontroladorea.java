package kontroladorea;

import java.io.File;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import eredua.Kontsultak;
import eredua.langilea;
import eredua.departamentua;
import lehioa.Departamentua;
import lehioa.Enplegatua;
import lehioa.Formularioa;
import lehioa.Formularioa2;
import lehioa.Menua;
import lehioa.deptTxostena;
import lehioa.langTxostena;

public class Menukontroladorea {
	public static Logger logger = Logger.getLogger(Menukontroladorea.class);
	private Menua menua;
	private Departamentua departamentua;
	private Enplegatua enplegatua;

	private Formularioa formularioa;
	private Formularioa2 formularioa2;
	private deptTxostena depttxostena;
	private langTxostena langtxostena;

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
	public void nireFormularioa2(Formularioa2 formularioa2) {
		this.formularioa2 = formularioa2;

	}
	public void nireTxostena1(deptTxostena depttxostena) {
		this.depttxostena=depttxostena;
	}
	public void nireTxostena(langTxostena langtxostena) {
		this.langtxostena=langtxostena;
	}

	// *************************
	// DEPARTAMENTUA
	public void departamentuaPantailara() {
		menua.setVisible(false);
		departamentua.setVisible(true);
	}
	
	
	
	//Formulario2
	public void formulario2Pantailara() {
		departamentua.setVisible(false);
		formularioa2.setVisible(true);
	}
	public void formulario2tikDepartamentura() {
		formularioa2.setVisible(false);
		departamentua.setVisible(true);
	}
	//**
	
	
	//Txostena DEPERTAMENTUA
	public void departamentutikTxostenara() {
		ArrayList<departamentua> zerrenda =Kontsultak.ateraDepartamentuak();
		depttxostena.gordeTxostena(zerrenda);
		depttxostena.filtroapart();
		departamentua.setVisible(false);
		depttxostena.setVisible(true);
	}
	public void txostenatikDepartamentura() {
		depttxostena.setVisible(false);
		departamentua.setVisible(true);
	}
	
	//***
	
	//Txostena LANGILEA
		public void langiletikTxostenara() {
			ArrayList<langilea> zerrenda =Kontsultak.ateraLangileak();
			langtxostena.gordeTxostena(zerrenda);
			langtxostena.filtroapart();
			enplegatua.setVisible(false);
			langtxostena.setVisible(true);
		}
		public void langiletikDepartamentura() {
			langtxostena.setVisible(false);
			departamentua.setVisible(true);
		}
		
		//***
	
	

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
	
	
	
	
	//***Formularioen kudeaketa
	//***Departamentua
	public void txertatuDepatamentua(departamentua dept) {
		int dept_zenbakia = Kontsultak.ateraZenbakiamaximoa();
		dept_zenbakia = dept_zenbakia+1;
		dept.setDept_no(dept_zenbakia);
		int zenbakia = Kontsultak.sartuDepartamentua(dept);
		if(zenbakia>0) {
			logger.info("Elementu bat sartu egin da: "+dept.getDept_no());
			formularioa2.operazioa();
		}
		else {
			formularioa2.txertatuErrorea();
		}
	}
	public void ezabatuDepatamentua(departamentua dept) {
		boolean existitzen = Kontsultak.depart_state(dept);
		if (existitzen) {
			int ezabatuta = Kontsultak.departamentuaEzabatuta(dept);
			if(ezabatuta == 1) {
				logger.info("Elementu bat ezabatu egin da: "+dept.getDept_no());
				formularioa2.operazioa();
			}
			
		}
		
		else {
			formularioa2.ezdago();		
			}
	}
	public void aldatuDepartamentu(departamentua dept) {
		boolean existitzen = Kontsultak.depart_state(dept);
		if (existitzen) {
			int ezabatuta = Kontsultak.departamentuaAldatu(dept);
			if(ezabatuta == 1) {
				logger.info("Elementu bat Aldatu egin da: id "+dept.getDept_no());
				formularioa2.operazioa();
			}
			
		}
		
		else {
			formularioa2.ezdago();		}
		
	}
	//Amaiera departamentua

}