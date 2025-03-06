package br.com.rafaelblomer.jpa;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rafaelblomer.dao.jpa.ClienteRepository;
import br.com.rafaelblomer.domain.jpa.ClienteJpa;
import br.com.rafaelblomer.exceptions.DAOException;
import br.com.rafaelblomer.exceptions.MaisDeUmRegistroException;
import br.com.rafaelblomer.exceptions.TableException;
import br.com.rafaelblomer.exceptions.TipoChaveNaoEncontradaException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteJpaDaoTest {
	
	@Autowired
	private ClienteRepository repo;
	
	private Random rd;
	
	public ClienteJpaDaoTest() {
		rd = new Random();
	}
	
	@Before
	public void setup() {
	    assertNotNull(repo);
	}
	
	@After
	public void end() throws DAOException {
		Collection<ClienteJpa> list = repo.findAll();
		list.forEach(cli -> {
			repo.delete(cli);
		});
	}
	
	@Test
	public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		ClienteJpa cliente = criarCliente();
		repo.save(cliente);
		
		ClienteJpa clienteConsultado = repo.findById(cliente.getId()).orElseThrow();
		Assert.assertNotNull(clienteConsultado);
		
	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = repo.save(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa clienteConsultado = repo.findById(retorno.getId()).orElseThrow();
		Assert.assertNotNull(clienteConsultado);
		
		repo.delete(cliente);
			
	}
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = repo.save(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa clienteConsultado = repo.findById(cliente.getId()).orElseThrow();
		Assert.assertNotNull(clienteConsultado);
		
		repo.delete(cliente);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = repo.save(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa clienteConsultado = repo.findById(cliente.getId()).orElseThrow();
		Assert.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Rodrigo Pires");
		repo.save(clienteConsultado);
		
		ClienteJpa clienteAlterado = repo.findById(clienteConsultado.getId()).orElseThrow();
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());
		
		repo.delete(cliente);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = repo.save(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa cliente1 = criarCliente();
		ClienteJpa retorno1 = repo.save(cliente1);
		Assert.assertNotNull(retorno1);
		
		Collection<ClienteJpa> list = repo.findAll();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			repo.delete(cli);
		});
		
		Collection<ClienteJpa> list1 = repo.findAll();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
	
	private ClienteJpa criarCliente() {
		ClienteJpa cliente = new ClienteJpa();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}

}
