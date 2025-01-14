/**
 * 
 */
package br.com.rafaelblomer.services;

import br.com.rafaelblomer.dao.IProdutoDAO;
import br.com.rafaelblomer.domain.Produto;
import br.com.rafaelblomer.services.generics.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
