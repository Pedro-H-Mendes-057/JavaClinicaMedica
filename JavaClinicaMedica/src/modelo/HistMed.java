package modelo;

public class HistMed {
//<<<<<<< HEAD
	/*private String[] alergia;
	private String[] cronicCondic;
	private String[] doencaPrev;*/
	private String[] historico;
//=======
	
	public HistMed() {
		
	}
//>>>>>>> branch 'main' of https://github.com/Pedro-H-Mendes-057/JavaClinicaMedica.git

	public HistMed(String[] historico) {
		super();
		this.historico = historico;
	}

	public String[] getHistMed() {
		return historico;
	}

	public void setHistMed(String[] historico) {
		this.historico = historico;
	}
	
	
}
