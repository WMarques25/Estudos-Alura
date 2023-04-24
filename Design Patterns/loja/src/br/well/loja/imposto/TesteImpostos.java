package br.well.loja.imposto;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.well.loja.orcamento.Orcamento;

public class TesteImpostos {
    @Test
    public void deveCalcularImpostoICMS() {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
        CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
        BigDecimal valor = calculadora.calcular(orcamento, new ICMS());
        assertEquals(new BigDecimal("10.00"), valor);
    }

    @Test
    public void deveCalcularImpostoISS() {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
        CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
        BigDecimal valor = calculadora.calcular(orcamento, new ISS());
        assertEquals(new BigDecimal("6.00"), valor);
    }

}
