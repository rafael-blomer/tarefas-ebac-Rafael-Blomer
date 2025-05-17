package br.com.rafaelblomer.service;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.rafaelblomer.dao.IProdutoDAO;
import br.com.rafaelblomer.domain.Produto;

@ApplicationScoped
public class ProdutoService implements IProdutoService {

    private IProdutoDAO produtoDAO;

    public ProdutoService() {
    }

    @Inject
    public ProdutoService(IProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public Produto cadastrar(Produto produto){
    	System.out.println("criar2");
        return produtoDAO.cadastrar(produto);
    }

    @Override
    public void excluir(Produto produto){
        produtoDAO.excluir(produto);
    }

    @Override
    public Produto alterar(Produto produto){
        return produtoDAO.alterar(produto);
    }

    @Override
    public Produto consultar(Long id){
        return produtoDAO.consultar(id);
    }

    @Override
    public Collection<Produto> buscarTodos(){
        return produtoDAO.buscarTodos();
    }
}

