package br.com.rafaelblomer.microservices.Produto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.rafaelblomer.microservices.Produto.repository")
public class MongoConfig {

}
