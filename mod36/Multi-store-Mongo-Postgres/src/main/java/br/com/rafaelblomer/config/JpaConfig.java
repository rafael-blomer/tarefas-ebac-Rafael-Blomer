package br.com.rafaelblomer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "br.com.rafaelblomer.customer")
public class JpaConfig {

}
