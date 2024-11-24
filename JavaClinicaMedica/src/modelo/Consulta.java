package modelo;

public class Consulta {
	private String data;
	private String hora;
	private int chaveMedico;
	private int chavePaciente;
	private String queixa;
	private String tipoConsulta;
	private String convenio;
	private String observacoes;
	private int [] chaveMateriais;
	
	public Consulta(String data, String hora, int chaveMedico, int chavePaciente, String queixa, String tipoConsulta,
			String convenio, String observacoes, int [] chaveMateriais) {
		super();
		this.data = data;
		this.hora = hora;
		this.chaveMedico = chaveMedico;
		this.chavePaciente = chavePaciente;
		this.queixa = queixa;
		this.tipoConsulta = tipoConsulta;
		this.convenio = convenio;
		this.observacoes = observacoes;
		this.chaveMateriais = chaveMateriais;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getMedico() {
		return this.chaveMedico;
	}

	public void setMedico(int chaveMedico) {
		this.chaveMedico = chaveMedico;
	}

	public int getPaciente() {
		return this.chavePaciente;
	}

	public void setPaciente(int chavePaciente) {
		this.chavePaciente = chavePaciente;
	}

	public String getQueixa() {
		return queixa;
	}

	public void setQueixa(String queixa) {
		this.queixa = queixa;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public int[] getMateriaisUsar() {
		return this.chaveMateriais;
	}

	public void setMateriaisUsar(int[] chaveMateriais) {
		this.chaveMateriais = chaveMateriais;
	}
	
	
	
}
