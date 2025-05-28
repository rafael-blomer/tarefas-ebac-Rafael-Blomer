package br.com.rafaelblomer.microservices.Cliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelblomer.microservices.Cliente.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
