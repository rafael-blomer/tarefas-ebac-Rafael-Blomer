/**
 * 
 */
package br.com.rafaelblomer.services;

import br.com.rafaelblomer.dao.IClienteDAO;
import br.com.rafaelblomer.domain.Cliente;
import br.com.rafaelblomer.exceptions.DAOException;
import br.com.rafaelblomer.exceptions.MaisDeUmRegistroException;
import br.com.rafaelblomer.exceptions.TableException;
import br.com.rafaelblomer.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
