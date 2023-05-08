package br.well.loja.imposto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.well.loja.orcamento.Orcamento;

public class CalculadoraDeImposto {
    
    public BigDecimal calcular(Orcamento orcamento, Imposto tipoImposto) {
     
        BigDecimal valor = tipoImposto.calcular(orcamento);
        return valor.setScale(2, RoundingMode.HALF_UP);
        
    }
}
