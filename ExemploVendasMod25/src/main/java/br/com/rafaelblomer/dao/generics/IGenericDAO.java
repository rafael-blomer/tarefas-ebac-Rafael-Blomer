package br.com.rafaelblomer.dao.generics;

import java.io.Serializable;
import java.util.Collection;

import br.com.rafaelblomer.domain.Persistente;
import br.com.rafaelblomer.exceptions.TipoChaveNaoEncontradaException;


public interface IGenericDAO <T extends Persistente, E extends Serializable> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    public void excluir(E valor);

    public void alterar(T entity) throws TipoChaveNaoEncontradaException;

    public T consultar(E valor);

    public Collection<T> buscarTodos();
}
