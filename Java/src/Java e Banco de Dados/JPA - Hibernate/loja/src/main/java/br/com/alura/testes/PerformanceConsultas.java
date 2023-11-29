package br.com.alura.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.dao.ClienteDAO;
import br.com.alura.dao.PedidoDAO;
import br.com.alura.dao.ProdutoDAO;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.Pedido;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class PerformanceConsultas {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        Pedido pedido = pedidoDAO.buscarPedidoComCliente(1l);
        em.close();
        System.out.println(pedido.getCliente().getNome());
    }
    
    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("4000"), videogames);
        Produto macbook = new Produto("MacBook", "Macbook pro retina", new BigDecimal("14000"), informatica);
        
        Cliente cliente = new Cliente("Rodrigo", "123456");

        EntityManager em = JPAUtil.getEntityManager();
        ClienteDAO clienteDAO = new ClienteDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        PedidoDAO pedidoDAO = new PedidoDAO(em);

        em.getTransaction().begin();

        categoriaDAO.cadastrar(celulares);
        categoriaDAO.cadastrar(videogames);
        categoriaDAO.cadastrar(informatica);

        produtoDAO.cadastrar(celular);
        produtoDAO.cadastrar(videogame);
        produtoDAO.cadastrar(macbook);

        clienteDAO.cadastrar(cliente);

        pedidoDAO.cadastrar(new Pedido(cliente));

        em.getTransaction().commit();
        em.close();
    }
}
