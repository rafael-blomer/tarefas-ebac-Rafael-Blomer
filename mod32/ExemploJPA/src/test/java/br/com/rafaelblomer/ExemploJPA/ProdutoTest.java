package br.com.rafaelblomer.ExemploJPA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.rafaelblomer.ExemploJPA.dao.IProdutoDAO;
import br.com.rafaelblomer.ExemploJPA.dao.ProdutoDAO;
import br.com.rafaelblomer.ExemploJPA.domain.Produto;

@SpringBootTest
public class ProdutoTest {

    @Autowired
    private IProdutoDAO dao =  new ProdutoDAO();

    private Produto produto;

    @BeforeEach
    public void criarObjeto() {
        produto = new Produto("arroz", "alimento", 10.50);
        produto = dao.cadastrar(produto); 
    }

    @Test
    public void cadastrar() {
        Produto novoProduto = new Produto("feijão", "alimento", 8.99);
        Produto cadastrado = dao.cadastrar(novoProduto);
        
        assertNotNull(cadastrado);
        assertNotNull(cadastrado.getId());
        dao.excluir(novoProduto.getId());
    }

    @Test
    public void buscar() {
        Produto buscado = dao.getProduto(produto.getId());
        
        assertNotNull(buscado);
        assertEquals(produto.getId(), buscado.getId());
    }

    @Test
    public void buscarTodos() {
        Produto novo = new Produto("feijão", "alimento", 8.99);
        dao.cadastrar(novo);
        
        List<Produto> list = dao.getAllProduto();
        
        assertNotNull(list);
        assertFalse(list.isEmpty()); 
    }

    @Test
    public void alterar() {
        produto.setNome("TV");
        produto.setDescricao("eletrônico");
        produto.setPreco(1500d);
        
        Produto alterado = dao.alterar(produto);
        
        assertNotNull(alterado);
        assertEquals("TV", alterado.getNome());
        assertEquals("eletrônico", alterado.getDescricao());
    }

    @Test
    public void excluir() {
        dao.excluir(produto.getId());
        Produto excluido = dao.getProduto(produto.getId());
        
        assertNull(excluido);
    }
}
