package cadastroClientes.dao;

import java.util.Collection;

import cadastroClientes.domain.Cliente;

public interface IClienteDAO {
	
	Boolean cadastrar(Cliente cliente);
    
    Boolean excluir(Long cpf);
    
    void alterar(Cliente cliente);
    
    Cliente consultar(Long cpf);

    Collection<Cliente> buscarTodos();
}
