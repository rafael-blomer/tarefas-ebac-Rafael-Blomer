package br.com.rafaelblomer.dao.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelblomer.domain.secondary.ProdutoJpaSecondary;

@Repository
public interface ProdutoRepositorySecondary extends JpaRepository<ProdutoJpaSecondary, Long> {

}
