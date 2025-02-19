package br.com.rafaelblomer.ExemploJPA.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.rafaelblomer.ExemploJPA.domain.Produto;
import br.com.rafaelblomer.ExemploJPA.repository.ProdutoRepository;

@Repository
public class ProdutoDAO implements IProdutoDAO {

	@Autowired
	private ProdutoRepository repo;

	@Override
	public Produto cadastrar(Produto produto) {
		return repo.save(produto);
	}

	@Override
	public void excluir(Long id) {
		repo.deleteById(id);

	}

	@Override
	public Produto getProduto(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Produto> getAllProduto() {
		return repo.findAll();
	}

	@Override
	public Produto alterar(Produto produto) {
		return repo.save(produto);
	}

}
