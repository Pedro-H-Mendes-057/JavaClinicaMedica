package modelo;

public class Consulta {
	private String data;
	private String hora;
	private Medico medico;
	private Paciente paciente;
	private String queixa;
	private String tipoConsulta;
	private String convenio;
	private String observacoes;
	private String materiaisUsar; //tambem interessante usar ArrayList
	
	public Consulta(String data, String hora, Medico medico, Paciente paciente, String queixa, String tipoConsulta,
			String convenio, String observacoes, String materiaisUsar) {
		super();
		this.data = data;
		this.hora = hora;
		this.medico = medico;
		this.paciente = paciente;
		this.queixa = queixa;
		this.tipoConsulta = tipoConsulta;
		this.convenio = convenio;
		this.observacoes = observacoes;
		this.materiaisUsar = materiaisUsar;
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

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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

	public String getMateriaisUsar() {
		return materiaisUsar;
	}

	public void setMateriaisUsar(String materiaisUsar) {
		this.materiaisUsar = materiaisUsar;
	}
	
	
	
}
