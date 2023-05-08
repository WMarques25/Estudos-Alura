package br.well.loja.desconto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.well.loja.orcamento.Orcamento;

public class SemDesconto extends Desconto{

    public SemDesconto() {
        super(null);
    }

    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return true;
    }
    
}
