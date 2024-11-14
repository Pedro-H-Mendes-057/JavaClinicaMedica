package modelo;

public class Medico {
	private String nome;
	private String especialidade;
	private String crm;
	private String contato;
	private String[] horasAtend;
	private double valorConsulta;
	
	public Medico(){
		
	}
	
	public Medico(String nome, String especialidade, String crm, String contato, String[] horasAtend, double valorConsulta) {
		this.nome = nome;
		this.especialidade = especialidade;
		this.crm = crm;
		this.contato = contato;
		this.horasAtend = horasAtend;
		this.valorConsulta = valorConsulta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String[] getHorasAtend() {
		return horasAtend;
	}

	public void setHorasAtend(String[] horasAtend) {
		this.horasAtend = horasAtend;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	
	
	
}
