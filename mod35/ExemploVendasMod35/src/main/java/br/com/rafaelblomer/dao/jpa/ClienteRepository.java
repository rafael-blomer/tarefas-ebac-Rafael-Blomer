package br.com.rafaelblomer.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelblomer.domain.jpa.ClienteJpa;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteJpa, Long> {

}
