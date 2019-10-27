package eredua;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class langilea {

	private int langile_kod;
	private String izena;
	private String abizena;
	private int dept_no;
	private double soldata;
	private int nagusia;
	private String ardura;
	private String dataOrdua;

	public langilea(int langile_kod, String izena, String abizena, int dept_no, double soldata, int nagusia,
			String ardura, String dataOrdua) {
		super();
		this.langile_kod = langile_kod;
		this.dept_no = dept_no;
		this.soldata = soldata;
		this.izena = izena;
		this.abizena = abizena;
		this.nagusia = nagusia;
		this.ardura = ardura;
		this.dataOrdua = dataOrdua;
	}

	public int getLangile_kod() {
		return langile_kod;
	}

	public void setLangile_kod(int langile_kod) {
		this.langile_kod = langile_kod;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public double getSoldata() {
		return soldata;
	}

	public void setSoldata(double soldata) {
		this.soldata = soldata;
	}

	public int getNagusia() {
		return nagusia;
	}

	public void setNagusia(int nagusia) {
		this.nagusia = nagusia;
	}

	public String getArdura() {
		return ardura;
	}

	public void setArdura(String ardura) {
		this.ardura = ardura;
	}

	public String getDataOrdua() {
		return dataOrdua;
	}

	public void setDataOrdua(String dataOrdua) {
		this.dataOrdua = dataOrdua;
	}

	public static void txtKudeatu2(String fitxategi, String formatua) {
		String kk = System.getProperty("line.separator");
		File archivo = new File(fitxategi + formatua);
		FileReader fr = null;
		try {
			fr = new FileReader(archivo);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		ArrayList<langilea> zerrenda = new ArrayList<langilea>();
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			int kodea = 0;
			int departamentua = 0;
			Double soldata = 0.0;
			String izena = "";
			String abizena = "";
			int nagusia = 0;
			String Ardura = "";
			Date date = new Date();
			String data = "";
			String ordua = "";

			// Lectura del fichero
			String linea;
			int kontagailua = 0;
			while ((linea = br.readLine()) != null) {
				kontagailua += 1;
				switch (kontagailua) {
				case 1:
					kodea = Integer.parseInt(ateraDatua(linea));
					System.out.println(kodea);
					break;
				case 2:
					departamentua = Integer.parseInt(ateraDatua(linea));
					System.out.println(departamentua);
					break;
				case 3:
					soldata = Double.parseDouble(ateraDatua(linea));
					System.out.println(soldata);
					break;
				case 4:
					izena = ateraDatua(linea);
					System.out.println(izena);
					break;
				case 5:
					abizena = ateraDatua(linea);
					System.out.println(abizena);
					break;
//	        		   departamentua dep = new departamentua(zentro_deptno,zentro_izena,zentro_eraikina,zentro);
//	        		   zerrenda.add(dep);
//	        		   idatxi(dep);

				case 6:
					nagusia = Integer.parseInt(ateraDatua(linea));
					System.out.println(nagusia);
					break;
				case 7:
					Ardura = ateraDatua(linea);
					System.out.println(Ardura);
					break;
				case 8:
					DateFormat hourFormat = new SimpleDateFormat("HH:mm");
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					data = dateFormat.format(date).toString();
					ordua = hourFormat.format(date).toString();
					String dataOrdua = (data + "," + ordua);
					langilea dep = new langilea(kodea, izena, abizena,departamentua, soldata, nagusia, Ardura, dataOrdua);
					zerrenda.add(dep);
					break;

				}

				if (kontagailua == 8) {
					kontagailua = 0;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();

				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

//		txertatuDepartamentua(zerrenda);
		Kontsultak.datuakSartu2(zerrenda);

	}

	private static String ateraDatua(String linea) {
		String hitza = "";
		String[] kk = linea.split(":");
		hitza = kk[1];
		return hitza;
	}

	public int getDept_nozenbakia() {
		return dept_no;
	}

	public void setDept_nozenbakia(int dept_no) {
		this.dept_no = dept_no;
	}

}
