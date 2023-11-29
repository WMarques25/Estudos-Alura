package br.com.alura.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.modelo.Pedido;
import br.com.alura.vo.RelatorioDeVendasVo;

public class PedidoDAO {

    private EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        this.em.persist(pedido);
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public List<RelatorioDeVendasVo> relatiorioDeVendas(){
        String jpql = "SELECT new br.com.alura.vo.RelatorioDeVendasVo(produto.nome, SUM(item.quantidade) , MAX(pedido.data)) "
            + "FROM Pedido pedido "
            + "JOIN pedido.itens item "
            + "JOIN item.produto produto "
            + "GROUP BY produto.nome "
            + "ORDER BY SUM(item.quantidade) DESC";
        return em.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
    }

    public Pedido buscarPedidoComCliente(Long id) {
        return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    // public void atualizar(Produto pedido) {
    //     this.em.merge(pedido);
    // }

    // public void remover(Produto produto) {
    //     produto = em.merge(produto);
    //     this.em.remove(produto);
    // }

    // public Produto buscarPorId(Long id) {
    //     return em.find(Produto.class, id);
    // }

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
