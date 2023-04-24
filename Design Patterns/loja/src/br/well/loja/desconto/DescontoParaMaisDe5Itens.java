package br.well.loja.desconto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.well.loja.orcamento.Orcamento;

public class DescontoParaMaisDe5Itens extends Desconto{
    public DescontoParaMaisDe5Itens(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal calcular(Orcamento orcamento) {
        if(orcamento.getQuantidadeItens() > 5) {
            return orcamento.getValor().multiply(new BigDecimal("0.1"))
                    .setScale(2, RoundingMode.HALF_UP);
        }
        
        return proximo.calcular(orcamento);
    }
}
