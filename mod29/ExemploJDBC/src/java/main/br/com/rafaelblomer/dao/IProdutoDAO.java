package br.com.rafaelblomer.dao;

import java.util.List;

import br.com.rafaelblomer.domain.Produto;

public interface IProdutoDAO {

	Integer cadastrar(Produto produto) throws Exception;

	Produto consultar(String codigo) throws Exception;

	Integer excluir(Produto produto) throws Exception;
	
	List<Produto> buscarTodos() throws Exception;
	
	Integer atualizar(Produto produto) throws Exception;
}
