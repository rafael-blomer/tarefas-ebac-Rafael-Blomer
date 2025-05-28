package br.com.rafaelblomer.microservices.Produto.business;

import br.com.rafaelblomer.microservices.Produto.domain.Produto;
import br.com.rafaelblomer.microservices.Produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Optional<Produto> findById(String id) {
        return repository.findById(id);
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public Produto update(String id, Produto produtoAtualizado) {
        return repository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());
            return repository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
