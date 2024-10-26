package modelo;

public class Exame {
	private Paciente paciente;
	private String descricao;
	private String tipo;
	private String valorParticular;
	private String materiaisUsar; //seria interessante um ArrayList pra guardar os materiais necessarios no exame
	private Medico medico;
	
	public Exame(Paciente paciente, String descricao, String tipo, String valorParticular, String materiaisUsar,
			Medico medico) {
		super();
		this.paciente = paciente;
		this.descricao = descricao;
		this.tipo = tipo;
		this.valorParticular = valorParticular;
		this.materiaisUsar = materiaisUsar;
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValorParticular() {
		return valorParticular;
	}

	public void setValorParticular(String valorParticular) {
		this.valorParticular = valorParticular;
	}

	public String getMateriasUsar() {
		return materiaisUsar;
	}

	public void setMateriasUsar(String materiaisUsar) {
		this.materiaisUsar = materiaisUsar;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
}
