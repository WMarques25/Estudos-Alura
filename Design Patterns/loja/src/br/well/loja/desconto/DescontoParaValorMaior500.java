package br.well.loja.desconto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.well.loja.orcamento.Orcamento;

public class DescontoParaValorMaior500 extends Desconto{

    public DescontoParaValorMaior500(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal calcular(Orcamento orcamento) {
        if(orcamento.getValor().compareTo(new BigDecimal("500")) > 0) {
            return orcamento.getValor().multiply(new BigDecimal("0.1"))
                        .setScale(2, RoundingMode.HALF_UP);            
        }
        
        return proximo.calcular(orcamento);
    }
}
