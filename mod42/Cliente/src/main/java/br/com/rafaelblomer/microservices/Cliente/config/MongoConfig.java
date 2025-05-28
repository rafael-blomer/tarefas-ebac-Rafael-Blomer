package br.com.rafaelblomer.microservices.Cliente.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.rafaelblomer.microservices.Cliente.repository")
public class MongoConfig {

}
