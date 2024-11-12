package cadastroClientes.dao;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import cadastroClientes.domain.Cliente;

public class ClienteMapDAO implements IClienteDAO {
    
    private Map<Long, Cliente> map;
    
    public ClienteMapDAO() {
        map = new TreeMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (map.containsKey(cliente.getCpf())) 
            return false;
        
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public Boolean excluir(Long cpf) {
        Cliente clienteCadastrado = map.get(cpf);
        
        if(clienteCadastrado != null) {
        	map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        	return true;
        }
        return false;
        	
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = map.get(cliente.getCpf());
        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }

}
