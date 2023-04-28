package br.well.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.well.loja.orcamento.Orcamento;
import br.well.loja.pedido.acao.AcaoAposGerarPedido;


public class GeraPedidoHandler {
    private List<AcaoAposGerarPedido> acoes;
    private Pedido pedido;
    
    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }
    
    public void execute(GeraPedido dados) {
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
        pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
        
        acoes.forEach(a -> a.executarAcao(pedido));

    }

    public Pedido getPedido() {
        return pedido;
    }
}
