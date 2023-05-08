package br.well.loja.pedido.acao;

import br.well.loja.pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido{
    
    public void executarAcao(Pedido pedido) {
        System.out.println("Enviando email com dados do novo pedido!");
    }
}
