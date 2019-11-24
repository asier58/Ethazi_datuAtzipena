package kontroladorea;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.json.JSONException;

import eredua.Kontsultak;
import eredua.departamentua;
import eredua.langilea;
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
	/**
	 * ENPLEGATUA
	 */

	
	
	public void getData(langilea l1) {
		//Kontsultak.datuakSartu2(l1);
		int departamentuaExistituta=0;
		departamentuaExistituta = Kontsultak.zuzendari(l1);
		if(departamentuaExistituta >0) {
		if(l1.getArdura().equalsIgnoreCase("zuzendari")) {
			int zenbakia = Kontsultak.zuzendariakAtera(l1);
			if(zenbakia==2) {
				formularioa.txertatuErrorea();
			}
			else {
				Kontsultak.datuakSartu2(l1);
				formularioa.operazioa();
			}
		}
		else {
		if(l1.getArdura().equalsIgnoreCase("Ikasketa burua")) {
		int zenbakia = Kontsultak.departamentuBurua(l1);
		if(zenbakia>0) {
			formularioa.txertatuErrorea();
		}
		else {
			formularioa.operazioa();
			Kontsultak.datuakSartu2(l1);
			logger.info("Elementu bat sartu egin da: " + l1.getIzena());
		}}
		else {
			Kontsultak.datuakSartu2(l1);
		}
			}
		}
		else {
			formularioa.departamentuaEzdaexistitzen();
		}
		
	}
	
	public void getLangileKodKontr(ArrayList<langilea> zerrenda, int kod) {
		Kontsultak.getLangile_kodBD(zerrenda, kod);
		logger.info("Langilearen kodea ondo lortu da.");
	}
	
	public void eguneratuEnplegatuakKontr(langilea l1) {
		Kontsultak.datuakEguneratuBD(l1);
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
	
	public int maxEmpleKod() {
		int maxEmpleKod = Kontsultak.ateraEnplegatumaximoa();
		
		return maxEmpleKod + 1;
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

	public void langilePantailara() {
		menua.setVisible(false);
		enplegatua.setVisible(true);
	}
	public void formularioPantailara() {
		enplegatua.setVisible(false);
		
		ArrayList<Integer> abiyua = Kontsultak.ateraEnplegatuKod(); 
		
		ArrayList<String>  departamentuuak = Kontsultak.pantailaratuDepartamentuak();
		formularioa.kargatuDepartamentuak(departamentuuak);
		Hashtable<String, Integer> pasitoa = Kontsultak.hashi();
		formularioa.kargatuDiccionario(pasitoa);
		
		formularioa.kargatuAL(abiyua);
		formularioa.blokeatuKodea();
		formularioa.setVisible(true);
	}
	
	public ArrayList<Integer> pasatuLangileKod(){
		ArrayList<Integer> ret;
		
		ret = Kontsultak.ateraEnplegatuKod();
		
		return ret;
	}
	
	public void enplegatuaBerritu(langilea l1) {
		Kontsultak.datuakBerritu1(l1);
		logger.info(l1.getIzena() + "-ren datuak berritu egin dira");
	}
	
	public void enplegatuaEzabatu(langilea l1) {
		Kontsultak.enplegatuEzabatuta(l1);
		logger.info(l1.getIzena() + " enplegatua ezabatu egin da.");
	}

	public ArrayList<Integer> returnKodea(){
		return Kontsultak.ateraLangile_Kod();
	}

	public void parametroakHartu(String fitxategi, String formatua)  {
		File fitx = new File(fitxategi + formatua);
		if (!fitx.exists()) {
			logger.error("Fitxategia ez da existitzen");
			departamentua.erroreaAtera();
		}

		else {

			if (formatua.equalsIgnoreCase(".Json")) {
				eredua.departamentua.jsonKudeatu(fitxategi, formatua);
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

			if (formatua.equalsIgnoreCase(".Json")) {
				eredua.langilea.jsonKudeatu2(fitxategi, formatua);
			}

			
			if(formatua.equalsIgnoreCase(".xml")) {
				eredua.langilea.xmlKudeatu2(fitxategi,formatua);
				}

			if (formatua.equalsIgnoreCase(".csv")) {
				eredua.langilea.csvkudeatu2(fitxategi, formatua);
			}
		}

	}
	
	

	public void departamentutikMenura() {
		departamentua.setVisible(false);
		menua.setVisible(true);
		
	}
	public void langiletikMenura() {
		enplegatua.setVisible(false);
		menua.setVisible(true);
	}
	
	public ArrayList<String> getArduraZuz(langilea l1){
		ArrayList<String> al = new ArrayList<String>();
		al = Kontsultak.arduraZuzendari(l1);
		return al;
	}
	
	public ArrayList<String> getArduraIB(langilea l1){
		ArrayList<String> al = new ArrayList<String>();
		al = Kontsultak.arduraIkasketaBurua(l1);
		return al;
	}
	
	
	//***Formularioen kudeaketa
	//***Departamentua
	public void txertatuDepatamentua(departamentua dept) {
		int dept_zenbakia = Kontsultak.ateraZenbakiamaximoa();
		dept_zenbakia = dept_zenbakia+1;
		dept.setDept_no(dept_zenbakia);
		int zenbakia = Kontsultak.sartuDepartamentua(dept);
		if(zenbakia>0) {
			logger.info("Elementu bat sartu egin da: "+dept.getDept_no()+" "+dept.getIzena()+" "+dept.getEraikina()+" "+dept.getZentroa());
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
				logger.info("Elementu bat ezabatu egin da: "+dept.getDept_no()+" "+dept.getIzena()+" "+dept.getEraikina()+" "+dept.getZentroa());
				formularioa2.operazioa();
			}
			
		}
		
		else {
			formularioa2.ezdago();
			logger.error("Ezin izan da elementua ezabatu, ez da existitzen.");
			}
	}
	public void aldatuDepartamentu(departamentua dept) {
		boolean existitzen = Kontsultak.depart_state(dept);
		if (existitzen) {
			int ezabatuta = Kontsultak.departamentuaAldatu(dept);
			if(ezabatuta == 1) {
				logger.info("Elementu bat aldatu egin da: "+dept.getDept_no()+" "+dept.getIzena()+" "+dept.getEraikina()+" "+dept.getZentroa());
				formularioa2.operazioa();
			}
			
		}
		
		else {
			formularioa2.ezdago();
			logger.error("Elementua ez da existitzen.");}
		
	}
	//Amaiera departamentua
	public  void departamentuKontrolerrorea() {
		departamentua.txertatuErrorea();
	}

	public void formularioToenplegatua() {
		formularioa.setVisible(false);
		enplegatua.setVisible(true);
	}

	public void txostenaTOenplegatua() {
		langtxostena.setVisible(false);
		enplegatua.setVisible(true);
		
	}
	public Boolean zuzendariZentroa(langilea lang) {
		return null;
		
	}

}