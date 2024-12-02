package modelo;

import java.util.List;

public class Exame {
	private String nomeExame;
	private String descricao;
	private String tipo;
	private int valorParticular;
	private List<Material> materiaisUsar; //seria interessante um ArrayList pra guardar os materiais necessarios no exame
	private Medico medico;
	
	public Exame() {
		
	}
	
	public Exame(String nomeExame, String descricao, String tipo, int valorParticular, List<Material> materiaisUsar,
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

	public int getValorParticular() {
		return valorParticular;
	}

	public void setValorParticular(int valorParticular) {
		this.valorParticular = valorParticular;
	}

	public String getMateriasUsar() {
		return materiaisUsar;
	}

	public void setMateriasUsar(List<Material> materiaisUsados) {
		this.materiaisUsar = materiaisUsados;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
}
