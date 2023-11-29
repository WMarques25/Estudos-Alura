package br.com.alura.dao;

import javax.persistence.EntityManager;

import br.com.alura.modelo.Cliente;

public class ClienteDAO {

    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente) {
        this.em.persist(cliente);
    }

    // public void atualizar(Produto pedido) {
    //     this.em.merge(pedido);
    // }

    // public void remover(Produto produto) {
    //     produto = em.merge(produto);
    //     this.em.remove(produto);
    // }

    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }

    // public List<Produto> buscarTodos() {
    //     String jpql = "SELECT p FROM Produto p";
    //     return em.createQuery(jpql, Produto.class).getResultList();
    // }

    // public List<Produto> buscarPorNome(String nome) {
    //     String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
    //     return em.createQuery(jpql, Produto.class)
    //             .setParameter("nome", nome)
    //             .getResultList();
    // }

    // public List<Produto> buscarPorNomeDaCategoria(String nome) {
    //     String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
    //     return em.createQuery(jpql, Produto.class)
    //             .setParameter("nome", nome)
    //             .getResultList();
    // }

    // public BigDecimal buscarPreçoPorNome(String nome) {
    //     String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
    //     return em.createQuery(jpql, BigDecimal.class)
    //             .setParameter("nome", nome)
    //             .getSingleResult();
    // }
    
}
