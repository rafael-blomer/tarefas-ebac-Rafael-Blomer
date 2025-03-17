package br.com.rafaelblomer.dao.tertiary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelblomer.domain.tertiary.ProdutoJpaTertiary;

@Repository
public interface ProdutoRepositoryTertiary extends JpaRepository<ProdutoJpaTertiary, Long> {

}
