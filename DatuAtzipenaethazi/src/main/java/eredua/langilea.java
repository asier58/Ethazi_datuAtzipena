package eredua;

public class langilea {

	private int langile_kod;
	private String izena;
	private String abizena;
	private String dept_no;
	private double soldata;
	private int nagusia;
	private String ardura;
	private String dataOrdua;

	public langilea(int langile_kod, String izena, String abizena, String dept_no, double soldata, int nagusia,
			String ardura, String dataOrdua) {
		super();
		this.langile_kod = langile_kod;
		this.izena = izena;
		this.abizena = abizena;
		this.dept_no = dept_no;
		this.soldata = soldata;
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

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
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

}
