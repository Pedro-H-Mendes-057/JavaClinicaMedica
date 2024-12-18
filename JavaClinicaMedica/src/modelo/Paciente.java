package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Paciente {
	private String nome;
	private String dataNasc;
	private String contato;
	private String tipoSang;
	private double altura;
	private double peso;
	private String histMed;
	private String convenio;
	private Endereco endereco;
	
	public Paciente() {

	}
	
	public Paciente(String nome, String dataNasc, String contato, String tipoSang, int altura, double peso,
			String histMed, String convenio, Endereco endereco) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.contato = contato;
		this.tipoSang = tipoSang;
		this.altura = altura;
		this.peso = peso;
		this.histMed = histMed;
		this.convenio = convenio;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTipoSang() {
		return tipoSang;
	}

	public void setTipoSang(String string) {
		this.tipoSang = string;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getHistMed() {
		return histMed;
	}

	public void setHistMed(String histMed) {
		this.histMed = histMed;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
