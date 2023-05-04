package br.well.loja.imposto;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.well.loja.orcamento.ItemOrcamento;
import br.well.loja.orcamento.Orcamento;

public class TesteImpostos {
    @Test
    public void deveCalcularImpostoICMS() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
        BigDecimal valor = calculadora.calcular(orcamento, new ICMS(null));
        assertEquals(new BigDecimal("10.00"), valor);
    }

    @Test
    public void deveCalcularImpostoICMSeISS() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
        BigDecimal valor = calculadora.calcular(orcamento, new ICMS(new ISS(null)));
        assertEquals(new BigDecimal("16.00"), valor);
    }

    @Test
    public void deveCalcularImpostoISS() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
        BigDecimal valor = calculadora.calcular(orcamento, new ISS(null));
        assertEquals(new BigDecimal("6.00"), valor);
    }

    @Test
    public void deveCalcularImpostoISSeICMS() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
        BigDecimal valor = calculadora.calcular(orcamento, new ICMS(new ISS(null)));
        assertEquals(new BigDecimal("16.00"), valor);
    }

}
