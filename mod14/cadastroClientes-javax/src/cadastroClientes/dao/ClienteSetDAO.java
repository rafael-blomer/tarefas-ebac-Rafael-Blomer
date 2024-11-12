package cadastroClientes.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import cadastroClientes.domain.Cliente;

public class ClienteSetDAO implements IClienteDAO {
    
    private Set<Cliente> set;
    
    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
    	Cliente trueOrFalse = consultar(cliente.getCpf());
    	if (trueOrFalse == null)
    		return this.set.add(cliente);
    	return false;
    }

    @Override
    public Boolean excluir(Long cpf) {
        Cliente clienteEncontrato = null;
        for (Cliente cliente : this.set) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrato = cliente;
                break;
            }
        }
        
        if (clienteEncontrato != null) {
            this.set.remove(clienteEncontrato);
            return true;
        }
        return false;
    }

    @Override
    public void alterar(Cliente cliente) {
        if (this.set.contains(cliente)) {
            for (Cliente clienteCadastrado : this.set) {
                if (clienteCadastrado.equals(cliente)) {
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setTel(cliente.getTel());
                    clienteCadastrado.setNumero(cliente.getNumero());
                    clienteCadastrado.setEnd(cliente.getEnd());
                    clienteCadastrado.setCidade(cliente.getCidade());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    break;
                }
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente clienteCadastrado : this.set) {
             if (clienteCadastrado.getCpf().equals(cpf)) {
                 return clienteCadastrado;
             }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }

}
