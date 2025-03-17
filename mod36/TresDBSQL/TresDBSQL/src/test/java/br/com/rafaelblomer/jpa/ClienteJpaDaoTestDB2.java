package br.com.rafaelblomer.jpa;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rafaelblomer.dao.secondary.ClienteRepositorySecondary;
import br.com.rafaelblomer.domain.secondary.ClienteJpaSecondary;
import br.com.rafaelblomer.exceptions.DAOException;
import br.com.rafaelblomer.exceptions.MaisDeUmRegistroException;
import br.com.rafaelblomer.exceptions.TableException;
import br.com.rafaelblomer.exceptions.TipoChaveNaoEncontradaException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteJpaDaoTestDB2 {

	@Autowired
	private ClienteRepositorySecondary clienteDao;

	private Random rd;

	public ClienteJpaDaoTestDB2() {
		rd = new Random();
	}

	@After
	public void end() throws DAOException {
		Collection<ClienteJpaSecondary> list = clienteDao.findAll();
		for (ClienteJpaSecondary c : list) {
			clienteDao.delete(c);
		}
	}

	@Test
	public void pesquisarCliente()
			throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		ClienteJpaSecondary cliente = criarCliente();
		clienteDao.save(cliente);

		ClienteJpaSecondary clienteConsultado = clienteDao.findById(cliente.getId()).get();
		Assert.assertNotNull(clienteConsultado);

	}

	@Test
	public void salvarCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpaSecondary cliente = criarCliente();
		ClienteJpaSecondary retorno = clienteDao.save(cliente);
		Assert.assertNotNull(retorno);

		ClienteJpaSecondary clienteConsultado = clienteDao.findById(retorno.getId()).get();
		Assert.assertNotNull(clienteConsultado);

		clienteDao.delete(cliente);

		ClienteJpaSecondary clienteConsultado1 = clienteDao.findById(retorno.getId()).get();
		Assert.assertNull(clienteConsultado1);
	}

	@Test
	public void deleteCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpaSecondary cliente = criarCliente();
		ClienteJpaSecondary retorno = clienteDao.save(cliente);
		Assert.assertNotNull(retorno);

		ClienteJpaSecondary clienteConsultado = clienteDao.findById(cliente.getId()).get();
		Assert.assertNotNull(clienteConsultado);

		clienteDao.delete(cliente);
		clienteConsultado = clienteDao.findById(cliente.getId()).get();
		Assert.assertNull(clienteConsultado);
	}

	@Test
	public void saveCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpaSecondary cliente = criarCliente();
		ClienteJpaSecondary retorno = clienteDao.save(cliente);
		Assert.assertNotNull(retorno);

		ClienteJpaSecondary clienteConsultado = clienteDao.findById(cliente.getId()).get();
		Assert.assertNotNull(clienteConsultado);

		clienteConsultado.setNome("Rodrigo Pires");
		clienteDao.save(clienteConsultado);

		ClienteJpaSecondary clienteAlterado = clienteDao.findById(clienteConsultado.getId()).get();
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());

		clienteDao.delete(cliente);
		clienteConsultado = clienteDao.findById(clienteAlterado.getId()).get();
		Assert.assertNull(clienteConsultado);
	}

	@Test
	public void findAll() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJpaSecondary cliente = criarCliente();
		ClienteJpaSecondary retorno = clienteDao.save(cliente);
		Assert.assertNotNull(retorno);

		ClienteJpaSecondary cliente1 = criarCliente();
		ClienteJpaSecondary retorno1 = clienteDao.save(cliente1);
		Assert.assertNotNull(retorno1);

		Collection<ClienteJpaSecondary> list = clienteDao.findAll();
		assertTrue(list != null);
		assertTrue(list.size() == 2);

		for (ClienteJpaSecondary c : list) {
			clienteDao.delete(c);
		}

		Collection<ClienteJpaSecondary> list1 = clienteDao.findAll();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}

	private ClienteJpaSecondary criarCliente() {
		ClienteJpaSecondary cliente = new ClienteJpaSecondary();
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