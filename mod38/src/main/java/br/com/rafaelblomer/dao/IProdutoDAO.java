package br.com.rafaelblomer.dao;

import java.util.Collection;

import br.com.rafaelblomer.domain.Produto;

public interface IProdutoDAO {

    Produto cadastrar(Produto produto);

    void excluir(Produto produto);

    Produto alterar(Produto produto);

    Produto consultar(Long id);

    Collection<Produto> buscarTodos();
}

