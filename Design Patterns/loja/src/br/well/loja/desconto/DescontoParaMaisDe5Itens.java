package br.well.loja.desconto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.well.loja.orcamento.Orcamento;

public class DescontoParaMaisDe5Itens extends Desconto{
    public DescontoParaMaisDe5Itens(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"))
                        .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getQuantidadeItens() > 5;
    }

    
}
