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
import br.com.rafaelblomer.services.ClienteService;
import br.com.rafaelblomer.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDao dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Rafael");
		cliente.setCidade("Lages");
		cliente.setEnd("Rua 1");
		cliente.setEstado("SC");
		cliente.setNumero(20);
		cliente.setTel(3333333333L);
	}

	@Test
	public void PesquisarCliente() {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteService.cadastrar(cliente);
		assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Rafael Ceccatto");
		clienteService.alterar(cliente);
		
		assertEquals("Rafael Ceccatto", cliente.getNome());
	}
}
