package br.com.rafaelblomer.microservices.Produto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelblomer.microservices.Produto.domain.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {

}
