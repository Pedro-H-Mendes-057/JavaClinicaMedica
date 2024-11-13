package modelo;

public class Exame {
	private String nomeExame;
	private String descricao;
	private String tipo;
	private String valorParticular;
	private String materiaisUsar; //seria interessante um ArrayList pra guardar os materiais necessarios no exame
	private Medico medico;
	
	public Exame(String nomeExame, String descricao, String tipo, String valorParticular, String materiaisUsar,
			Medico medico) {
		super();
		this.nomeExame = nomeExame;
		this.descricao = descricao;
		this.tipo = tipo;
		this.valorParticular = valorParticular;
		this.materiaisUsar = materiaisUsar;
		this.medico = medico;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
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
