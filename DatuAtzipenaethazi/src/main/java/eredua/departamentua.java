package eredua;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class departamentua {

	private int dept_no;
	private String izena;
	private String eraikina;
	private String zentroa;

	public departamentua(int dept_no, String izena, String eraikina, String zentroa) {

		this.dept_no = dept_no;
		this.izena = izena;
		this.eraikina = eraikina;
		this.zentroa = zentroa;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getEraikina() {
		return eraikina;
	}

	public void setEraikina(String eraikina) {
		this.eraikina = eraikina;
	}

	public String getZentroa() {
		return zentroa;
	}

	public void setZentroa(String zentroa) {
		this.zentroa = zentroa;
	}

	public static void txtKudeatu(String fitxategi, String formatua) {
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
		ArrayList<departamentua> zerrenda = new ArrayList<departamentua>();
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			int zentro_deptno = 0;
			String zentro_izena = "";
			String zentro = "";
			String zentro_eraikina = "";

			// Lectura del fichero
			String linea;
			int kontagailua = 0;
			while ((linea = br.readLine()) != null) {
				kontagailua += 1;
				switch (kontagailua) {
				case 1:
					zentro_deptno = Integer.parseInt(ateraDatua(linea));
					System.out.println(zentro_deptno);
					break;
				case 2:
					zentro_izena = ateraDatua(linea);
					System.out.println(zentro);
					break;
				case 3:
					zentro_eraikina = ateraDatua(linea);
					System.out.println(zentro_eraikina);
					break;
				case 4:
					zentro = ateraDatua(linea);
					System.out.println(zentro);
					break;
				case 5:
					departamentua dep = new departamentua(zentro_deptno, zentro_izena, zentro_eraikina, zentro);
					zerrenda.add(dep);
					idatxi(dep);
					break;

				}

				if (kontagailua == 5) {
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

		Kontsultak.datuakSartu1(zerrenda);
	}

	private static String ateraDatua(String linea) {
		String hitza = "";
		String[] kk = linea.split(":");
		hitza = kk[1];
		return hitza;
	}

	public static void idatxi(departamentua departamentu) throws IOException {
		int idatzita = 0;
		File d = new File("departamentua.csv");
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(d, true);
			bw = new BufferedWriter(fw);

			bw.newLine();
			bw.write(departamentu.dept_no + "," + departamentu.izena + "," + departamentu.getEraikina() + ","
					+ departamentu.zentroa);
			bw.flush(); // txt-an idatzitakoa gortzeko
			idatzita = 1;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void csvkudeatu(String fitxategi, String formatua) {
		ArrayList<departamentua> zerrenda = new ArrayList<departamentua>();
		int zentro_deptno = 0;
		String zentro_izena = "";
		String zentro = "";
		String zentro_eraikina = "";
		int contador = 0;
		String SAMPLE_CSV_FILE_PATH = fitxategi + formatua;

		try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) {
			for (CSVRecord csvRecord : csvParser) {
				// Accessing Values by Column Index
				if (contador != 0) {
					zentro_deptno = Integer.parseInt(csvRecord.get(0));
					zentro_izena = csvRecord.get(1);
					zentro_eraikina = csvRecord.get(2);
					zentro = csvRecord.get(3);
					System.out.println(zentro_deptno);
					System.out.println(zentro_izena);
					System.out.println(zentro);
					System.out.println(zentro_eraikina);
					departamentua dep = new departamentua(zentro_deptno, zentro_izena, zentro_eraikina, zentro);
					zerrenda.add(dep);
				}

				contador++;
			}
			reader.close();
			csvParser.close();
		} catch (Exception e) {
			zerrenda = null;
		}
		txertatuDepartamentua(zerrenda);

	}

	// Aitor basatirrrrrr
	public static void txertatuDepartamentua(ArrayList<departamentua> arr) {

	}

}
