/**
 * 
 */
package br.com.rafaelblomer.services;

import br.com.rafaelblomer.domain.Cliente;
import br.com.rafaelblomer.exceptions.DAOException;
import br.com.rafaelblomer.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
