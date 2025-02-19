package br.com.rafaelblomer.ExemploJPA.dao;

import java.util.List;

import br.com.rafaelblomer.ExemploJPA.domain.Produto;

public interface IProdutoDAO {

	Produto cadastrar(Produto produto);
	
	void excluir(Long id);
	
	Produto getProduto(Long id);
	
	List<Produto> getAllProduto();
	
	Produto alterar(Produto produto);
}
