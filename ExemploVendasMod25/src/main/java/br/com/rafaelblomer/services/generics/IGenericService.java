/**
 * 
 */
package br.com.rafaelblomer.services.generics;

import java.io.Serializable;
import java.util.Collection;

import br.com.rafaelblomer.domain.Persistente;
import br.com.rafaelblomer.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericService <T extends Persistente, E extends Serializable> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    public void alterar(T entity) throws TipoChaveNaoEncontradaException;
    
    public void excluir(E valor);
    
    public T consultar(E valor);

    public Collection<T> buscarTodos();

}
