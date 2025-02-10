package br.com.rafaelblomer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.rafaelblomer.dao.IProdutoDAO;
import br.com.rafaelblomer.dao.ProdutoDAO;
import br.com.rafaelblomer.domain.Produto;

public class ProdutoTest {

	private static Produto produto;
	
	private IProdutoDAO dao = new ProdutoDAO();
	
	@Before
	public void GerarProduto() {
		produto = new Produto();
		produto.setNome("Banana");
		produto.setCategoria(1);
		produto.setPreco(0.99F);
		produto.setCodigo("101010");
	}
	
	@Test
	public void deveCadastrarComSucesso() throws Exception {
		Integer result = dao.cadastrar(produto);
		assertTrue(result == 1);
	}
	
	@Test
	public void deveretornarPordutoComSucesso() throws Exception {
		Produto produtoNovo = dao.consultar(produto.getCodigo());
		assertNotNull(produtoNovo);
		assertNotNull(produtoNovo.getId());
		assertEquals(produto.getNome(), produtoNovo.getNome());
		assertEquals(produto.getCodigo(), produtoNovo.getCodigo());
		assertNotNull(produtoNovo.getCategoria());
		assertNotNull(produtoNovo.getPreco());
	}
	
	@Test
	public void deveAtualizarComSucesso() throws Exception {
		dao.cadastrar(produto);
	    
	    Produto produtoNovo = dao.consultar(produto.getCodigo());
	    assertNotNull(produtoNovo);
	    assertNotNull(produtoNovo.getId());

	    produtoNovo.setNome("TV");
	    produtoNovo.setCategoria(2);
	    produtoNovo.setCodigo("202020");
	    produtoNovo.setPreco(1500.50F);

	    Integer result = dao.atualizar(produtoNovo);
	    Produto produtoAtualizado = dao.consultar("202020");

	    assertTrue(result == 1);
	    assertEquals("TV", produtoAtualizado.getNome());
	    assertEquals("202020", produtoAtualizado.getCodigo());
	    assertTrue(produtoAtualizado.getCategoria() == 2);
	    assertTrue(produtoAtualizado.getPreco() == 1500.50F);
	}
	
	@Test
	public void deveBuscarTodosComSucesso() throws Exception {
		List<Produto> list = dao.buscarTodos(); 
		assertNotNull(list);
	}
	
	@Test
	public void deveExcluirComSucesso() throws Exception {
		Integer result = dao.excluir(produto);
		assertNotNull(result);
		assertNull(dao.consultar(produto.getCodigo()));
	}
}
