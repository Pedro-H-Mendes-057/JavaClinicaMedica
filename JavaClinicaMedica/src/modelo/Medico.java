package modelo;

public class Medico {
	private String nome;
	private String especialidade;
	private String crm;
	private String contato;
	private int[][] horariosAtendimento; // 1 == atende neste dia e neste horario  0 == não atende
	private double valorConsulta;
	
	public Medico(){
		
	}
	
	public Medico(String nome, String especialidade, String crm, String contato, int[][] horariosAtendimento, double valorConsulta) {
		this.nome = nome;
		this.especialidade = especialidade;
		this.crm = crm;
		this.contato = contato;
		this.horariosAtendimento = horariosAtendimento;
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

	public int[][] getHorasAtend() {
            if (this.horariosAtendimento == null) {
                this.horariosAtendimento = new int[11][5]; 
            }
            
            return this.horariosAtendimento;
	}

	public void setHorasAtend(int[][] horasAtend) {
		this.horariosAtendimento = horasAtend;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	
	
	
}
