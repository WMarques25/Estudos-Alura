package br.well.loja.pedido;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;

import br.well.loja.pedido.acao.*;

public class TestePedido {
    // Testes para pedidos
    @Test
    public void deveCriarPedido() {
        GeraPedido gerador = new GeraPedido("Wellington", new BigDecimal("100"), 10);
        GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(
                                                            new SalvarPedidoEmBD(), 
                                                            new EnviarEmailPedido()));
        handler.execute(gerador);
        Pedido pedido = handler.getPedido();
        pedido.getOrcamento().aprovar();
        pedido.getOrcamento().aplicarDescontoExtra();

        assertEquals("Wellington", pedido.getCliente());        
        assertEquals(new BigDecimal("98.00"), pedido.getOrcamento().getValor());
    }
}
