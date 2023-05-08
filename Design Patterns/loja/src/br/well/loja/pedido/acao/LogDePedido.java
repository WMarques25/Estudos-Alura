package br.well.loja.pedido.acao;

import br.well.loja.pedido.Pedido;

public class LogDePedido implements AcaoAposGerarPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Pedido foi gerado: " + pedido);
    }
    
}
