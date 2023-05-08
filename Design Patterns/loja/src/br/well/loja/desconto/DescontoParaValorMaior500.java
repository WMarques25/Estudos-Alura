package br.well.loja.desconto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.well.loja.orcamento.Orcamento;

public class DescontoParaValorMaior500 extends Desconto{

    public DescontoParaValorMaior500(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"))
                        .setScale(2, RoundingMode.HALF_UP);            
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
    }
}
