package br.com.rafaelblomer.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelblomer.domain.primary.ProdutoJpa;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoJpa, Long> {

}
