package br.com.rafaelblomer.dao;

import br.com.rafaelblomer.dao.generics.GenericDAO;
import br.com.rafaelblomer.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDao {
	
	public ClienteDAO() {
		super();
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		return Cliente.class;
	}

	@Override
	public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
		// TODO Auto-generated method stub
		
	}


}
