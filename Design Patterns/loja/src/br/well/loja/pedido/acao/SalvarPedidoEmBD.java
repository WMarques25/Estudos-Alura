package br.well.loja.pedido.acao;

import br.well.loja.pedido.Pedido;

public class SalvarPedidoEmBD implements AcaoAposGerarPedido{
    
    public void executarAcao(Pedido pedido) {
        System.out.println("Salvando dados do novo pedido!");
    }
}
