package br.com.rafaelblomer.jpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rafaelblomer.dao.jpa.ProdutoRepository;
import br.com.rafaelblomer.domain.jpa.ProdutoJpa;
import br.com.rafaelblomer.exceptions.DAOException;
import br.com.rafaelblomer.exceptions.MaisDeUmRegistroException;
import br.com.rafaelblomer.exceptions.TableException;
import br.com.rafaelblomer.exceptions.TipoChaveNaoEncontradaException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoJpaDaoTest {
	

	@Autowired
	private ProdutoRepository repo;
	
	@Before
	public void setup() {
	    assertNotNull(repo);
	}
	
	@After
	public void end() throws DAOException {
		Collection<ProdutoJpa> list = repo.findAll();
		list.forEach(cli -> {
			repo.delete(cli);
		});
	}
	
	@Test
	public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		ProdutoJpa produto = criarProduto("A1");
		Assert.assertNotNull(produto);
		ProdutoJpa produtoDB = repo.findById(produto.getId()).orElseThrow();
		Assert.assertNotNull(produtoDB);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		ProdutoJpa produto = criarProduto("A2");
		Assert.assertNotNull(produto);
	}
	
	@Test
	public void delete() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		ProdutoJpa produto = criarProduto("A3");
		Assert.assertNotNull(produto);
		repo.delete(produto);
	}
	
	@Test
	public void saveCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		ProdutoJpa produto = criarProduto("A4");
		produto.setNome("Rodrigo Pires");
		repo.save(produto);
		ProdutoJpa produtoBD = repo.findById(produto.getId()).orElseThrow();
		assertNotNull(produtoBD);
		Assert.assertEquals("Rodrigo Pires", produtoBD.getNome());
	}
	
	@Test
	public void findAll() throws DAOException, TipoChaveNaoEncontradaException {
		criarProduto("A5");
		criarProduto("A6");
		Collection<ProdutoJpa> list = repo.findAll();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		for (ProdutoJpa prod : list) {
			this.repo.delete(prod);
		}
		
		list = repo.findAll();
		assertTrue(list != null);
		assertTrue(list.size() == 0);
		
	}
	
	private ProdutoJpa criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
		ProdutoJpa produto = new ProdutoJpa();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		repo.save(produto);
		return produto;
	}
}