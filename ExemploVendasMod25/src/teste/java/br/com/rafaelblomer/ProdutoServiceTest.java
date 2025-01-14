package br.com.rafaelblomer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.rafaelblomer.dao.IProdutoDAO;
import br.com.rafaelblomer.dao.ProdutoDaoMock;
import br.com.rafaelblomer.domain.Produto;
import br.com.rafaelblomer.exceptions.TipoChaveNaoEncontradaException;
import br.com.rafaelblomer.services.IProdutoService;
import br.com.rafaelblomer.services.ProdutoService;

public class ProdutoServiceTest {

	private Produto produto;

	private IProdutoService service;

	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		service = new ProdutoService(dao);
	}

	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("1");
		produto.setNome("Produto");
		produto.setDescricao("Descrição 1");
		produto.setValor(BigDecimal.ONE);
	}

	@Test
	public void pesquisar() {
		Produto produtopesquisado = service.consultar(produto.getCodigo());
		assertNotNull(produtopesquisado);
	}

	@Test
	public void salvar() throws TipoChaveNaoEncontradaException {
		Boolean retorno = service.cadastrar(produto);
		assertTrue(retorno);
	}

	@Test
	public void excluir() {
		service.excluir(produto.getCodigo());
		// assertNull(produto);
	}

	@Test
	public void alterarProduto() throws TipoChaveNaoEncontradaException {
		produto.setNome("Produto 10");
		service.alterar(produto);

		assertEquals("Produto 10", produto.getNome());
	}

}
