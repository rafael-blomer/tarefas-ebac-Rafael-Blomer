package br.com.rafaelblomer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.rafaelblomer.dao.ClienteDaoMock;
import br.com.rafaelblomer.dao.IClienteDao;
import br.com.rafaelblomer.domain.Cliente;
import br.com.rafaelblomer.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDaoTest {

	private IClienteDao clienteDao;

	private Cliente cliente;

	public ClienteDaoTest() {
		clienteDao = new ClienteDaoMock();
	}

	@Before
	public void init() throws TipoChaveNaoEncontradaException{
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Rafael");
		cliente.setCidade("Lages");
		cliente.setEnd("Rua 1");
		cliente.setEstado("SC");
		cliente.setNumero(20);
		cliente.setTel(3333333333L);

		clienteDao.cadastrar(cliente);
	}

	@Test
	public void PesquisarCliente() {
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

		assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteDao.cadastrar(cliente);
		assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Rafael Ceccatto");
		clienteDao.alterar(cliente);
		
		assertEquals("Rafael Ceccatto", cliente.getNome());
	}
}
