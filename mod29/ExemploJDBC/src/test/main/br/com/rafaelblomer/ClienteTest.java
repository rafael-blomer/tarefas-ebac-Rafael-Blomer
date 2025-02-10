package br.com.rafaelblomer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.rafaelblomer.dao.ClienteDAO;
import br.com.rafaelblomer.dao.IClienteDAO;
import br.com.rafaelblomer.domain.Cliente;

public class ClienteTest {

	@Test
	public void cadastrarTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();
		
		//Testes cadastrar 
		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Rafael");
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		
		//Testes consultar
		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		//Testes atualizar
		cliente.setCodigo("000000");
		cliente.setNome("teste");
		cliente.setId(clienteBD.getId());
		Integer qtdAt = dao.atualizar(cliente);
		Cliente clienteAtualizado = dao.consultar("000000");
		assertNotNull(qtdAt);
		assertEquals("000000", clienteAtualizado.getCodigo());
		assertEquals("teste", clienteAtualizado.getNome());
		
		//Testes buscar todos
		List<Cliente> list = dao.buscarTodos();
		assertNotNull(list);
		
		//Testes excluir 
		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);
		assertNull(dao.consultar(clienteBD.getCodigo()));
		
	}
}
