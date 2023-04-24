package br.well.loja.desconto;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.well.loja.orcamento.Orcamento;

public class TesteDescontos {
    
    // Quantidade de itens maior que 5
    @Test
    public void deveCalcularDescontoZero() {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("0.00"), valor);
    }
    @Test
    public void deveCalcularDesconto10() {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 10);
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("10.00"), valor);
    }

    @Test
    public void deveCalcularDesconto20() {
        Orcamento orcamento = new Orcamento(new BigDecimal("200"), 6);
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("20.00"), valor);
    }

    // Valor maior que 500.00
    @Test
    public void deveCalcularDesconto0() {
        Orcamento orcamento = new Orcamento(new BigDecimal("500"), 2);
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("0.00"), valor);
    }

    @Test
    public void deveCalcularDesconto50() {
        Orcamento orcamento = new Orcamento(new BigDecimal("501"), 3);
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("50.10"), valor);
    }

    @Test
    public void deveCalcularDesconto60() {
        Orcamento orcamento = new Orcamento(new BigDecimal("600"), 6);
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("60.00"), valor);
    }

}
