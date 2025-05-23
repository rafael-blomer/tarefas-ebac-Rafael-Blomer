package br.com.rafaelblomer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.rafaelblomer.domain.Cliente;
import br.com.rafaelblomer.repositories.ClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages =  "br.com.rafaelblomer.repositories")
@EntityScan("br.com.rafaelblomer.*")
@ComponentScan(basePackages = "br.com.rafaelblomer")
public class SpringBootPrimeiroExemploApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootPrimeiroExemploApplication.class);
	
	@Autowired
	private ClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPrimeiroExemploApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
		
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.nome("Rafael")
				.email("rafael@teste.com")
				.build();
	}

}
