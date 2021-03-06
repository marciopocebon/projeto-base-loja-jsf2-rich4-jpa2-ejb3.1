package com.gugawag.projeto.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import com.gugawag.projeto.modelo.Carrinho;
import com.gugawag.projeto.modelo.Item;
import com.gugawag.projeto.modelo.Produto;
import com.gugawag.projeto.modelo.Usuario;
import com.gugawag.projeto.repositorio.PedidoRepositorio;

@Stateful
public class CarrinhoService {

	private Carrinho carrinho;
	private Usuario donoCarrinho;
	
	@EJB
	private PedidoRepositorio pedidoRepositorio;
		
	public CarrinhoService(){
		carrinho = new Carrinho();
	}

	public void salvarCarrinho() throws CarrinhoVazioException{
		if (carrinho.getItens().size() == 0){
			throw new CarrinhoVazioException();
		}
		pedidoRepositorio.salvarPedido(carrinho, donoCarrinho);
	}
	
	public void inserirProduto(Produto produto) {
		carrinho.insereItem(new Item(produto));		
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public void removerProduto(Produto produtoARemover) {
		carrinho.removerProduto(produtoARemover);
	}

	public Usuario getDonoCarrinho() {
		return donoCarrinho;
	}

	public void setDonoCarrinho(Usuario donoCarrinho) {
		this.donoCarrinho = donoCarrinho;
	}
	
}
