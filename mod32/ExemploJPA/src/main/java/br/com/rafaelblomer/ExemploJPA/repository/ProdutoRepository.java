package br.com.rafaelblomer.ExemploJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelblomer.ExemploJPA.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
