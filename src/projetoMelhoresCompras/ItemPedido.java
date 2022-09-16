package projetoMelhoresCompras;

public class ItemPedido {
	private int id;
	private Produto produto;
	private int qtdVendida;
	private double preco;
	
	
	
	public ItemPedido(){
		
	}
	public ItemPedido(int id, Produto produto, int qtdVendida, double preco) {
		super();
		this.id = id;
		this.produto = produto;
		this.qtdVendida = qtdVendida;
		this.preco = preco;
	}
	public int getId() {
		return id;	
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQtdVendida() {
		return qtdVendida;
	}
	public void setQtdVendida(int qtdVendida) {
		this.qtdVendida = qtdVendida;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
