package br.com.alura.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.dao.ClienteDAO;
import br.com.alura.dao.PedidoDAO;
import br.com.alura.dao.ProdutoDAO;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.ItemPedido;
import br.com.alura.modelo.Pedido;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroDePedido {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        Produto p = produtoDAO.buscarPorId(1l);
        Cliente cliente = clienteDAO.buscarPorId(1l);
        
        em.getTransaction().begin();
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, p));
        
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        pedidoDAO.cadastrar(pedido);
        em.getTransaction().commit();
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        
        Cliente cliente = new Cliente("Rodrigo", "123456");

        EntityManager em = JPAUtil.getEntityManager();
        ClienteDAO clienteDAO = new ClienteDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        em.getTransaction().begin();
        categoriaDAO.cadastrar(celulares);
        produtoDAO.cadastrar(celular);
        clienteDAO.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }
}
