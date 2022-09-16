package projetoMelhoresCompras;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Programa {

	public static void main(String[] args) throws IOException {
		Scanner ler = new Scanner(System.in);

		int opcao;

		ArrayList<Pedido> listaPedidos = new ArrayList<>();
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		ArrayList<Produto> listaProdutos = new ArrayList<>();
		ArrayList<ItemPedido> listaItemPedidos = new ArrayList<>();

		do {
			System.out.println("---------------------------");
			System.out.printf("  ===> Sistema (MVP) <===\n");
			System.out.println("---------------------------\n\n");
			System.out.printf("Escolha uma opção:\n");
			System.out.printf("1 - Cadastrar Cliente \n" + "2 - Excluir Cliente \n" + "3 - Listar Clientes \n"
					+ "4 - Cadastrar Produto \n" + "5 - Excluir Produto \n" + "6 - Listar Produtos \n"
					+ "7 - Criar Pedido \n" + "8 - Cancelar Pedido \n" + "9 - Listar Pedidos \n" + "10 - Sair\n\n");
			System.out.printf("Digite a opção desejada: ");
			opcao = ler.nextInt();

			if (opcao == 1) {
				int id = listaClientes.size() + 1;

				System.out.println("Digite o nome do cliente:");
				String nome = ler.next();

				System.out.println("Digite o email do cliente:");
				String email = ler.next();

				Cliente cliente = new Cliente(id, nome, email);
				listaClientes.add(cliente);

				System.out.println("Cliente cadastrado com sucesso!");

			} else if (opcao == 2) {
				for (Cliente c : listaClientes) {
					System.out.printf("ID: %d \nNOME: %s \n\n", c.getId(), c.getNome());
				}

				System.out.println("Digite o id do cliente que deseja excluir:");
				int id = ler.nextInt();

				Cliente cliente = listaClientes.get(id - 1);

				boolean clienteTemPedido = false;

				for (Pedido p : listaPedidos) {
					clienteTemPedido = p.clienteComPedido(cliente);
				}

				if (clienteTemPedido == false) {
					listaClientes.remove(cliente);
				}

			} else if (opcao == 3) {
				for (Cliente c : listaClientes) {
					System.out.printf("ID: %d \nNOME: %s \nEMAIL: %s \n\n", c.getId(), c.getNome(), c.getEmail());
				}

			} else if (opcao == 4) {
				int id = listaProdutos.size() + 1;

				System.out.println("Digite o nome do produto:");
				String nome = ler.next();

				System.out.println("Digite a quantidade em estoque do produto:");
				int qtdEstoque = ler.nextInt();

				System.out.println("Digite o preço do produto:");
				double preco = ler.nextDouble();

				System.out.println("Digite a categoria do produto:");
				String categoria = ler.next();

				Produto produto = new Produto(id, nome, qtdEstoque, preco, categoria);
				listaProdutos.add(produto);

			} else if (opcao == 5) {
				for (Produto p : listaProdutos) {
					System.out.printf("ID: %d \n NOME: %s", p.getId(), p.getNome());
				}

				System.out.println("Digite o id do produto que deseja excluir:");
				int id = ler.nextInt();

				Produto produto = listaProdutos.get(id - 1);
				
				boolean produtoEmUmPedido = false;

				for (Pedido p : listaPedidos) {
					produtoEmUmPedido = p.produtoNoPedido(produto);
				}

				if (produtoEmUmPedido == false) {
					listaProdutos.remove(produto);
				}

				System.in.read();
			} else if (opcao == 6) {

				for (Produto p : listaProdutos) {
					System.out.printf("ID: %d \nNOME: %s \nQUANTIDADE: %d \nPREÇO: %f \nCATEGORIA: %s \n\n", p.getId(),
							p.getNome(), p.getQtdEstoque(), p.getPreco(), p.getCategoria());
				}

			} else if (opcao == 7) {

				int id = listaPedidos.size() + 1;

				for (Cliente c : listaClientes) {
					System.out.printf("ID: %d - NOME: %s \n", c.getId(), c.getNome());
				}

				System.out.println("Digite o id do cliente que irá realizar o pedido:");
				int idCliente = ler.nextInt();

				Cliente cliente = null;
				
				for(Cliente c : listaClientes) {
					if (c.getId() == idCliente) {
						cliente = c;
					}
				}

				char adicionarPedido = 'S';

				do {

					int idItemPedido = listaItemPedidos.size() + 1;

					for (Produto p : listaProdutos) {
						System.out.printf("ID: %d \n NOME: %s", p.getId(), p.getNome());
					}

					System.out.println("Digite o id do produto que deseja adicionar em seu pedido");
					int idProduto = ler.nextInt();

					Produto produtoPedido = listaProdutos.get(idProduto - 1);

					System.out.println("Digite a quantidade vendida do produto");
					int quantidade = ler.nextInt();

					double precoTotal = quantidade * produtoPedido.getPreco();

					ItemPedido itemPedido = new ItemPedido(idItemPedido, produtoPedido, quantidade, precoTotal);
					listaItemPedidos.add(itemPedido);

					System.out.println("Deseja adicionar mais um produto? (S/N)");
					adicionarPedido = ler.next().charAt(0);

				} while (adicionarPedido == 'S');

				Pedido pedido = new Pedido(id, cliente, listaItemPedidos);
				
				listaPedidos.add(pedido);

				System.in.read();

			} else if (opcao == 8) {
				for (Pedido p : listaPedidos) {
					System.out.printf("ID: %d \nNOME CLIENTE: %s \n\n", p.getId(), p.getCliente().getNome());
				}

				System.out.println("Digite o id do pedido que deseja cancelar: ");
				int id = ler.nextInt();

				Pedido pedido = listaPedidos.get(id - 1);
				if (pedido.possoCancelar()) {
					for (ItemPedido item : pedido.getItensPedido()) {
						int idProduto = item.getProduto().getId();

						listaProdutos.get(idProduto - 1).atualizarQuantidade(item.getQtdVendida());
					}
				}

			} else if (opcao == 9) {
				for (Pedido p : listaPedidos) {
					System.out.printf("ID: %d \nNOME CLIENTE: %s \n\n", p.getId(), p.getCliente().getNome());
				}

			}

		} while (opcao != 10);

		ler.close();
	}

}
