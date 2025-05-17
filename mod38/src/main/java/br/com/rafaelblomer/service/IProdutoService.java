package br.com.rafaelblomer.service;

import java.util.Collection;

import br.com.rafaelblomer.domain.Produto;

public interface IProdutoService {

    Produto cadastrar(Produto produto);

    void excluir(Produto produto);

    Produto alterar(Produto produto);

    Produto consultar(Long id);

    Collection<Produto> buscarTodos();
}

