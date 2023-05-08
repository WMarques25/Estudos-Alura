package br.well.loja.pedido;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;

import br.well.loja.orcamento.ItemOrcamento;
import br.well.loja.orcamento.Orcamento;
import br.well.loja.pedido.acao.*;

public class TestePedido {
    // Testes para pedidos
    @Test
    public void deveCriarPedido() {
        Orcamento orcamento = new Orcamento();
        for(int i = 0; i < 10; i++) {
            orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("10")));
        }
        GeraPedido gerador = new GeraPedido("Wellington", orcamento);
        GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(
                                                            new SalvarPedidoEmBD(), 
                                                            new EnviarEmailPedido(),
                                                            new LogDePedido()));
        handler.execute(gerador);
        Pedido pedido = handler.getPedido();
        pedido.getOrcamento().aprovar();
        pedido.getOrcamento().aplicarDescontoExtra();

        assertEquals("Wellington", pedido.getCliente());        
        assertEquals(new BigDecimal("98.00"), pedido.getOrcamento().getValor());
    }
}
