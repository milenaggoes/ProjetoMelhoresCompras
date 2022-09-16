package projetoMelhoresCompras;

import java.util.ArrayList;

public class Pedido {
	private int id;
	private Cliente cliente;
	private ArrayList<ItemPedido> itensPedido;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(ArrayList<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pedido(int id, Cliente cliente, ArrayList<ItemPedido> itensPedido) {
		this.id = id;
		this.cliente = cliente;
		this.itensPedido = itensPedido;
		this.status = "Finalizado";
	}

	public void adicionarItemPedido(ItemPedido itemPedido) {
		if (itensPedido == null) {
			itensPedido = new ArrayList<ItemPedido>();
		}
		itensPedido.add(itemPedido);
	}

	public boolean possoCancelar() {
		if (status == "Finalizado") {
			setStatus("Cancelado");

			System.out.println("Pedido cancelado");
			return true;

		} else {
			System.out.println("Pedido já cancelado");
			return false;
		}
	}
	
	public boolean clienteComPedido(Cliente cliente) {
		if (this.cliente.getId() == cliente.getId()) {
			return true;
		} else {
			return false;
		}	
	}
	
	public boolean produtoNoPedido(Produto produto) {
		boolean produtoNoPedido = false;
		for(ItemPedido item : itensPedido) {
			produtoNoPedido = item.getProduto().getId() == produto.getId();
		}
		return produtoNoPedido;
	}

}
