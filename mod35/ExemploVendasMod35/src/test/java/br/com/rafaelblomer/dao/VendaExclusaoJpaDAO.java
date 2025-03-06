package br.com.rafaelblomer.dao;

import br.com.rafaelblomer.domain.jpa.VendaJpa;
import br.com.rafaelblomer.exceptions.DAOException;
import br.com.rafaelblomer.exceptions.TipoChaveNaoEncontradaException;

public class VendaExclusaoJpaDAO {

	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	public VendaJpa consultarComCollection(Long id) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

}