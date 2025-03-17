package br.com.rafaelblomer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rafaelblomer.customer.Address;
import br.com.rafaelblomer.customer.Customer;
import br.com.rafaelblomer.customer.CustomerRepository;
import br.com.rafaelblomer.shop.LineItem;
import br.com.rafaelblomer.shop.Order;
import br.com.rafaelblomer.shop.OrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class MultiStoreMongoPostgresApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	void repositoriesAreAssignedToAppropriateStores() {
		var repositories = new Repositories(context);
		
		assertThat(repositories.getEntityInformationFor(Customer.class)).isInstanceOf(JpaEntityInformation.class);
		assertThat(repositories.getEntityInformationFor(Order.class)).isInstanceOf(MongoEntityInformation.class);
	}
	
	@Test
	void cadastrarMongo() {
		LineItem items = new LineItem("t1", 1.0);
		Order order = new Order("1", new Date().from(Instant.now()), List.of(items));
		Order newOrder = orderRepository.save(order);
		
		assertNotNull(newOrder);
	}
	
	@Test
	void cadastrarJpa() {
		Address address = new Address();
		Point point = new Point(1, 2);
		address.setLocation(point);
		address.setStreet("Rua 3");
		address.setZipCode("111110000");
		
		Customer customer = new Customer("teste", "TESTE", address);
		Customer newcustomer = customerRepository.save(customer);
		
		assertNotNull(newcustomer);
	}

}
