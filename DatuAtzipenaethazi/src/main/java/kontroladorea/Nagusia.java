package kontroladorea;

import lehioa.Menua;

public class Nagusia {

	public static void main(String[] args) {
	Menukontroladorea menukontroladorea =  new Menukontroladorea();
		
		//Lehioak
		Menua menua = new Menua();
		
		
		//***********
		menukontroladorea.nireMenua(menua);
		menua.nireMenukontroladorea(menukontroladorea);
		//***********
		
		
		ON(menua);

	}

	private static void ON(Menua menua) {
		menua.setVisible(true);
		
	}

}
