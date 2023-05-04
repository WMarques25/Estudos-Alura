package br.well.loja.pedido;

import java.math.BigDecimal;

import br.well.loja.orcamento.Orcamento;

public class GeraPedido {
    
    private String cliente;
    private BigDecimal valorOrcamento;
    private int quantidadeItens;
    private Orcamento orcamento;
    
    public GeraPedido(String cliente, Orcamento orcamento) {
        this.cliente = cliente;
        this.orcamento = orcamento;
        this.valorOrcamento = orcamento.getValor();
        this.quantidadeItens = orcamento.getQuantidadeItens();
    }
    
    public String getCliente() {
        return cliente;
    }

    public BigDecimal getValorOrcamento() {
        return valorOrcamento;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

}
