package eredua;

public class departamentua {

	private int dept_no;
	private String izena;
	private String eraikina;
	private String zentroa;

	public departamentua(int dept_no, String izena, String eraikina, String zentroa) {
		super();
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

}
