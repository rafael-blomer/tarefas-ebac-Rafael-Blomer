package br.com.rafaelblomer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.rafaelblomer.shop")
public class MongoConfig {
	
	@Bean
	public MongoClient mongo() throws Exception{
		final ConnectionString cs = new ConnectionString("mongodb://localhost:27017/venda_online3");
		final MongoClientSettings mcs = MongoClientSettings.builder().applyConnectionString(cs).build();
		return MongoClients.create(mcs);
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception{
		return new MongoTemplate(mongo(), "vendas_online3");
	}

}
