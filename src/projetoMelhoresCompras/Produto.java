package projetoMelhoresCompras;

public class Produto {
	private int id;
	private String nome;
	private int qtdEstoque;
	private double preco;
	private String categoria;
	
	public Produto() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Produto(int id, String nome, int qtdEstoque, double preco, String categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtdEstoque = qtdEstoque;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	public void atualizarQuantidade(int quantidade) {
		this.qtdEstoque += quantidade;
	}
}
