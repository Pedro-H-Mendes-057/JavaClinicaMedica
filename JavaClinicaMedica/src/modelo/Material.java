package modelo;

public class Material {
	private String nome;
	private int quant;
	private int quantMin; //sistema alerta baixo estoque!!
	private String fornecedor;
	private String preco;
        
        public Material() {
        
        }
	
	public Material(String nome, int quant, int quantMin, String fornecedor, String preco) {
		super();
		this.nome = nome;
		this.quant = quant;
		this.quantMin = quantMin;
		this.fornecedor = fornecedor;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public int getQuantMin() {
		return quantMin;
	}

	public void setQuantMin(int quantMin) {
		this.quantMin = quantMin;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	
}
