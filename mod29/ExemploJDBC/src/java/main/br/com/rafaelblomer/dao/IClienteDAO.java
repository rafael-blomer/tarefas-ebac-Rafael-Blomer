package br.com.rafaelblomer.dao;

import java.util.List;

import br.com.rafaelblomer.domain.Cliente;

public interface IClienteDAO {

	Integer cadastrar(Cliente cliente) throws Exception;

	Cliente consultar(String codigo) throws Exception;

	Integer excluir(Cliente cliente) throws Exception;
	
	List<Cliente> buscarTodos() throws Exception;
	
	Integer atualizar(Cliente cliente) throws Exception;
}
