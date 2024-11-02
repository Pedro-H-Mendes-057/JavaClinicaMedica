package modelo;

public class HistMed {
//<<<<<<< HEAD
	/*private String[] alergia;
	private String[] cronicCondic;
	private String[] doencaPrev;*/
	private String[] histMed;
//=======
	
	public HistMed() {
		
	}
//>>>>>>> branch 'main' of https://github.com/Pedro-H-Mendes-057/JavaClinicaMedica.git

	public HistMed(String[] histMed) {
		super();
		this.histMed = histMed;
	}

	public String[] getHistMed() {
		return histMed;
	}

	public void setHistMed(String[] histMed) {
		this.histMed = histMed;
	}
	
	
}
