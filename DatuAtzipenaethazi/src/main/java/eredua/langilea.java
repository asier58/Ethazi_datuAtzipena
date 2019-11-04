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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class langilea {

	private int langile_kod;
	private int dept_nozenbakia;
	private double soldata;
	private String izena;
	private String abizena;
	private int nagusia;
	private String ardura;
	private String dataOrdua;

	public langilea(int langile_kod, int dept_nozenbakia, double soldata, String izena, String abizena, int nagusia,
			String ardura, String dataOrdua) {
		super();
		this.langile_kod = langile_kod;
		this.dept_nozenbakia = dept_nozenbakia;
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
	         while((linea=br.readLine())!=null) {
	        	 kontagailua+=1;
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
	        		   soldata = soldata*1000;
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
					langilea dep = new langilea(kodea, departamentua, soldata, izena, abizena, nagusia, Ardura,
							ordua + "," + data);
					zerrenda.add(dep);
					// idatxi2(dep);
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
		return dept_nozenbakia;
	}

	public void setDept_nozenbakia(int dept_nozenbakia) {
		this.dept_nozenbakia = dept_nozenbakia;
	}

	
	  public static void idatxi2(langilea Langilea) throws IOException {
		    int idatzita =0;
		    File d = new File("enplegatua.csv");
		    FileWriter fw;
		    BufferedWriter bw;
		    try {
		    fw = new FileWriter(d, true);
		    bw = new BufferedWriter(fw);
		   
		    bw.newLine();
		    bw.write(Langilea.langile_kod + "," + Langilea.dept_nozenbakia + "," + Langilea.soldata + "," + Langilea.izena+ "," + Langilea.abizena+ "," + Langilea.nagusia+ "," + Langilea.ardura+ "," + Langilea.dataOrdua);
		    bw.flush(); // txt-an idatzitakoa gortzeko
		    idatzita = 1;
		    } catch (IOException e) {
		    e.printStackTrace();
		    }
	    
	   }
	  public static void csvkudeatu2(String fitxategi, String formatua) {
			ArrayList<langilea> zerrenda = new ArrayList<langilea>();
			int kodea=0;
			int departamentua=0;
			Double soldata=0.0;
			String izena="";
			String abizena="";
			int nagusia=0;
			String Ardura="";
			Date date = new Date();
			String data ="";
			String ordua="";
			String SAMPLE_CSV_FILE_PATH = fitxategi+formatua;
			int contador =0;
			
		   
		     
		     try (
		             Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		         ) {
		             for (CSVRecord csvRecord : csvParser) {
		                 // Accessing Values by Column Index
		            	 if(contador!=0) {
		            		 kodea = Integer.parseInt(csvRecord.get(0));
		            		 departamentua = Integer.parseInt(csvRecord.get(1));
		            		 soldata = Double.parseDouble(csvRecord.get(2));
		            		 izena = csvRecord.get(3);
		            		 abizena = csvRecord.get(4);
		            		 nagusia = Integer.parseInt(csvRecord.get(5));
		            		 Ardura = csvRecord.get(6);
		            		 data = csvRecord.get(7);
		            		 soldata = soldata*1000;
		                  langilea dep = new langilea(kodea,departamentua,soldata,izena,abizena,nagusia,Ardura,data);
		        		  zerrenda.add(dep);
		        	     }
		            	 
		                contador ++;
		             }
		             reader.close();
		             csvParser.close();
		         }catch(Exception e) {
		        	 zerrenda = null;
		         }
		     Kontsultak.datuakSartu2(zerrenda);}
			


	public static void xmlKudeatu2(String fitxategi, String formatua) {
		ArrayList<langilea> zerrenda = new ArrayList<langilea>();
		int kodea=0;
		int departamentua=0;
		Double soldata=0.0;
		String izena="";
		String abizena="";
		int nagusia=0;
		String Ardura="";
		Date date = new Date();
		String data ="";
		String ordua="";

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(fitxategi+formatua);
            document.getDocumentElement().normalize();
            System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
            NodeList mezua = document.getElementsByTagName("record");
            String linea ="";
            int kontagailua =0;
           
            for (int temp = 0; temp < mezua.getLength(); temp++) {
                Node nodo = mezua.item(temp);
                System.out.println("Elemento:" + nodo.getNodeName());
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                   
       	        	 kontagailua+=1;
       	        	 switch (kontagailua) {
       	        	   case 1:
       	        		kodea = Integer.parseInt(element.getElementsByTagName("kodea").item(0).getTextContent());
       	        		    
       	        		   System.out.println(kodea);
       	        		   kontagailua+=1;
       	        		 
       	        	   case 2:
       	        		departamentua = Integer.parseInt(element.getElementsByTagName("dept_no").item(0).getTextContent());
       	        		  
       	        	     System.out.println(departamentua);
       	        	  kontagailua+=1;
       	        	     
       	        	   case 3:
       	        		soldata = Double.parseDouble(element.getElementsByTagName("soldata").item(0).getTextContent());
       	        		soldata = soldata*1000;
       	        		  
       	        	     System.out.println(soldata);
       	        	  kontagailua+=1;
       	        	     
       	        	   case 4:
       	        		izena = element.getElementsByTagName("izena").item(0).getTextContent();

       	        		    
       	        	     System.out.println(izena);
       	        	  kontagailua+=1;
       	        	     
       	        	   case 5:
       	        		abizena = element.getElementsByTagName("abizena").item(0).getTextContent();

   	        		    
      	        	     System.out.println(abizena);
      	        	  kontagailua+=1;
       	        		
       	        	   case 6:
       	        		nagusia = Integer.parseInt(element.getElementsByTagName("nagusia").item(0).getTextContent());
   	        		    
    	        		   System.out.println(nagusia);
    	        		   kontagailua+=1;
       	        		   
       	        	   case 7:
       	        		Ardura = element.getElementsByTagName("Ardura").item(0).getTextContent();
   	        		    
 	        		   System.out.println(Ardura);
 	        		  
       	        	   case 8:
       	        		DateFormat hourFormat = new SimpleDateFormat("HH:mm");
       	        		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 	        		    data =dateFormat.format(date).toString();
 	        		    ordua = hourFormat.format(date).toString();
       	        		langilea dep = new langilea(kodea,departamentua,soldata,izena,abizena,nagusia,Ardura,data+ordua);
       	        		zerrenda.add(dep);
      	        	    break;
       	        		   
       	        	   
       	        	     
       	        	 }	
       	        	 
       	        	 
       	        	 
       	        	 if(kontagailua ==8) {
       	        		 kontagailua=0;
       	        	 }
                
                }}}
       	        	 catch (Exception e) {
       	        		 e.printStackTrace();
       	        	 }
		Kontsultak.datuakSartu2(zerrenda);
		
		
	}



	


}
