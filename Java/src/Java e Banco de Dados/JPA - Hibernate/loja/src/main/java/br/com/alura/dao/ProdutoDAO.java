package br.com.alura.dao;

import javax.persistence.EntityManager;

public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Object produto) {
        this.em.persist(produto);
    }
    
}
