package br.com.rafaelblomer.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rafaelblomer.dao.VendaExclusaoJpaDAO;
import br.com.rafaelblomer.dao.jpa.ClienteRepository;
import br.com.rafaelblomer.dao.jpa.ProdutoRepository;
import br.com.rafaelblomer.dao.jpa.VendaRepository;
import br.com.rafaelblomer.domain.jpa.ClienteJpa;
import br.com.rafaelblomer.domain.jpa.ProdutoJpa;
import br.com.rafaelblomer.domain.jpa.VendaJpa;
import br.com.rafaelblomer.domain.jpa.VendaJpa.Status;
import br.com.rafaelblomer.exceptions.DAOException;
import br.com.rafaelblomer.exceptions.MaisDeUmRegistroException;
import br.com.rafaelblomer.exceptions.TableException;
import br.com.rafaelblomer.exceptions.TipoChaveNaoEncontradaException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendaJpaDaoTest {
	
	@Autowired
	private VendaRepository vendaRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	private Random rd;
	
	private ClienteJpa cliente;
	
	private ProdutoJpa produto;
	
	public VendaJpaDaoTest() {
		rd = new Random();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		this.cliente = saveCliente();
		this.produto = saveProduto("A1", BigDecimal.TEN);
	}
	
	@After
	public void end() throws DAOException {
		vendaRepo.deleteAll();
		produtoRepo.deleteAll();
		clienteRepo.deleteAll();
	}
	
	@Test
	public void pesquisar() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		VendaJpa venda = criarVenda("A1");
		VendaJpa retorno = vendaRepo.saveAndFlush(venda);
		assertNotNull(retorno);
		VendaJpa vendaConsultada = vendaRepo.findById(venda.getId()).orElseThrow();
		assertNotNull(vendaConsultada);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		VendaJpa venda = criarVenda("A2");
		VendaJpa retorno = vendaRepo.saveAndFlush(venda);
		assertNotNull(retorno);
		
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));
		
		VendaJpa vendaConsultada = vendaRepo.findById(venda.getId()).orElseThrow();
		assertTrue(vendaConsultada.getId() != null);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	} 
	
	@Test
	public void cancelarVenda() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A3";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaRepo.saveAndFlush(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		retorno.setStatus(Status.CANCELADA);
	}
	
	@Test
	public void adicionarMaisProdutosDoMesmo() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A4";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaRepo.saveAndFlush(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
	} 
	
	@Test
	public void adicionarMaisProdutosDiferentes() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A5";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaRepo.saveAndFlush(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = saveProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
	} 
	
	@Test(expected = AssertionError.class)
	public void salvarVendaMesmoCodigoExistente() throws TipoChaveNaoEncontradaException, DAOException {
		VendaJpa venda = criarVenda("A6");
		VendaJpa retorno = vendaRepo.saveAndFlush(venda);
		assertNotNull(retorno);
	
		VendaJpa venda1 = criarVenda("A6");
		vendaRepo.saveAndFlush(venda1);
		assertTrue(venda.getStatus().equals(Status.INICIADA));
	} 
	
	@Test
	public void removerProduto() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A7";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaRepo.saveAndFlush(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = saveProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
	} 
	
	@Test
	public void removerApenasUmProduto() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A8";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaRepo.saveAndFlush(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = saveProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
	} 
	
	@Test
	public void removerTodosProdutos() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A9";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaRepo.saveAndFlush(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = saveProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
	} 
	
	@Test
	public void finalizarVenda() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A10";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaRepo.saveAndFlush(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		venda.setStatus(Status.CONCLUIDA);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void tentarAdicionarProdutosVendaFinalizada() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A11";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaRepo.saveAndFlush(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		venda.setStatus(Status.CONCLUIDA);
	}

	private ProdutoJpa saveProduto(String codigo, BigDecimal valor) throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ProdutoJpa produto = new ProdutoJpa();
		produto.setId(null);
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(valor);
		produtoRepo.save(produto);
		return produto;
	}

	private ClienteJpa saveCliente() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJpa cliente = new ClienteJpa();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		clienteRepo.saveAndFlush(cliente);
		return cliente;
	}
	
	private VendaJpa criarVenda(String codigo) {
		VendaJpa venda = new VendaJpa();
		venda.setCodigo(codigo);
		venda.setDataVenda(Instant.now());
		venda.setCliente(this.cliente);
		venda.setStatus(Status.INICIADA);
		venda.adicionarProduto(this.produto, 2);
		return venda;
	}
}
