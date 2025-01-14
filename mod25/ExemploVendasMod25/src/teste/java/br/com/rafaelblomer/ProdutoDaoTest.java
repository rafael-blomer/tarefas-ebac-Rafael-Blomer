package br.com.rafaelblomer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import br.com.rafaelblomer.dao.IProdutoDAO;
import br.com.rafaelblomer.dao.ProdutoDAO;
import br.com.rafaelblomer.domain.Produto;
import br.com.rafaelblomer.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDaoTest {
	
	private IProdutoDAO dao;
	
	private Produto produto;

	public ProdutoDaoTest() {
		dao = new ProdutoDAO();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		produto = new Produto();
		produto.setCodigo("1");
		produto.setNome("Produto");
		produto.setDescricao("Descrição 1");
		produto.setValor(BigDecimal.ONE);
		dao.cadastrar(produto);
	}
	
	@Test
	public void pesquisar() {
		Produto produto = this.dao.consultar(this.produto.getCodigo());
		assertNotNull(produto);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException {
		produto.setCodigo("A2");
		Boolean retorno = dao.cadastrar(produto);
		assertTrue(retorno);
	}
	
	@Test
	public void excluir() {
		dao.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		produto.setNome("Rodrigo Pires");
		dao.alterar(produto);
		
		assertEquals("Rodrigo Pires", produto.getNome());
	}
	
	@Test
	public void buscarTodos() {
		Collection<Produto> list = dao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
	}
}
