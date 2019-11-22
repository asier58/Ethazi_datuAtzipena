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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lehioa.Departamentua;
import lehioa.Enplegatua;

public class langilea {

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



	private int langile_kod;
	private int dept_nozenbakia;
	private double soldata;
	private String izena;
	private String abizena;
	private int nagusia;
	private String ardura;
	private String dataOrdua;

	

	

	



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

	@Override
	public String toString() {
		return "langilea [langile_kod=" + langile_kod + ", dept_nozenbakia=" + dept_nozenbakia + ", soldata=" + soldata
				+ ", izena=" + izena + ", abizena=" + abizena + ", nagusia=" + nagusia + ", ardura=" + ardura
				+ ", dataOrdua=" + dataOrdua + "]";
	}

	public static void jsonKudeatu2(String fitxategi, String formatua) {
		JSONObject oharrita_mezuak = new JSONObject();
		JSONObject oharrita = new JSONObject();
		JSONArray zerrenda_oh = new JSONArray();

	
		JSONParser jsonParser = new JSONParser();
		
		try {
			FileReader reader = new FileReader(fitxategi+formatua);
			Object obj = jsonParser.parse(reader);
			JSONArray employeeList = (JSONArray) obj;
			employeeList.forEach(emp ->  parseDepObject((JSONObject) emp));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	private static void  parseDepObject(JSONObject employee) {
		JSONObject oharraObject = (JSONObject) employee.get("enplegatua");

		long kode =  (long) oharraObject.get("kodea");
		int kodea = Math.toIntExact(kode);
		
		long dept_n = (long) oharraObject.get("dept_no");
		System.out.println();
		int dept_no =  Math.toIntExact(dept_n);
		
		double soldata = (double) oharraObject.get("soldata");
		soldata =  soldata*1000;
		String izena = (String) oharraObject.get("izena");
		String abizena = (String) oharraObject.get("abizena");
		
		long nagus =  (long) oharraObject.get("nagusia");
		int nagusia = Math.toIntExact(kode);
		
		String ardura = (String) oharraObject.get("Ardura");
		String dataOrdua =  (String) oharraObject.get("dataOrdua");
		

		langilea lang =  new langilea(kodea, dept_no, soldata,  izena,abizena,nagusia,ardura, dataOrdua);
		Kontsultak.datuakSartu2(lang);
		//int zenbakia = Kontsultak.sartuDepartamentua(dept);
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
			int soldata=0;
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
		            		 soldata = Integer.parseInt(csvRecord.get(2));
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
		     Kontsultak.datuakSartu2(zerrenda.get(0));}
			


	public static void xmlKudeatu2(String fitxategi, String formatua) {
		ArrayList<langilea> zerrenda = new ArrayList<langilea>();
		int kodea=0;
		int departamentua=0;
		int soldata=0;
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
       	        		soldata = Integer.parseInt(element.getElementsByTagName("soldata").item(0).getTextContent());
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
		Kontsultak.datuakSartu2(zerrenda.get(0));
		
		
	}



	


}
