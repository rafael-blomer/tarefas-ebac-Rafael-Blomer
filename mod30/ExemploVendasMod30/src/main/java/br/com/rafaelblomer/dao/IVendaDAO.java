/**
 * 
 */
package br.com.rafaelblomer.dao;

import br.com.rafaelblomer.dao.generic.IGenericDAO;
import br.com.rafaelblomer.domain.Venda;
import br.com.rafaelblomer.exceptions.DAOException;
import br.com.rafaelblomer.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
