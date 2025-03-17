package br.com.rafaelblomer.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelblomer.domain.primary.ClienteJpa;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteJpa, Long> {

}
