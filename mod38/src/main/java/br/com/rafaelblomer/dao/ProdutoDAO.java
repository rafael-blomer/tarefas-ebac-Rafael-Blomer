package br.com.rafaelblomer.dao;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelblomer.domain.Produto;

@ApplicationScoped
public class ProdutoDAO implements IProdutoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Produto cadastrar(Produto produto){
        entityManager.persist(produto);
        return produto;
    }

    @Override
    public void excluir(Produto produto){
        if (entityManager.contains(produto)) {
            entityManager.remove(produto);
        } else {
            Produto managed = entityManager.find(Produto.class, produto.getId());
            if (managed != null) {
                entityManager.remove(managed);
            }
        }
    }

    @Override
    public Produto alterar(Produto produto){
        return entityManager.merge(produto);
    }

    @Override
    public Produto consultar(Long id){
        return entityManager.find(Produto.class, id);
    }

    @Override
    public Collection<Produto> buscarTodos(){
        String jpql = "SELECT p FROM Produto p";
        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }
}
