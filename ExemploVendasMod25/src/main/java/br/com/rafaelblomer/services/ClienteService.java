package br.com.rafaelblomer.services;

import br.com.rafaelblomer.dao.IClienteDao;
import br.com.rafaelblomer.domain.Cliente;
import br.com.rafaelblomer.services.generics.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	public ClienteService(IClienteDao clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) {
		return dao.consultar(cpf);
	}

}
