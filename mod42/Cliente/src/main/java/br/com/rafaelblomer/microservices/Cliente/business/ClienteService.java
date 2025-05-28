package br.com.rafaelblomer.microservices.Cliente.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelblomer.microservices.Cliente.domain.Cliente;
import br.com.rafaelblomer.microservices.Cliente.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Optional<Cliente> findById(String id) {
        return repository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente update(String id, Cliente clienteAtualizado) {
        return repository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            return repository.save(cliente);
        }).orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
