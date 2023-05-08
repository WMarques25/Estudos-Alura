package br.well.loja.desconto;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.well.loja.orcamento.ItemOrcamento;
import br.well.loja.orcamento.Orcamento;

public class TesteDescontos {
    
    // Quantidade de itens maior que 5
    @Test
    public void deveCalcularDescontoZero() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("0.00"), valor);
    }
    @Test
    public void deveCalcularDesconto10() {
        Orcamento orcamento = new Orcamento();
        for(int i = 0; i < 10; i++){
            orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("10")));
        }
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("10.00"), valor);
    }

    @Test
    public void deveCalcularDesconto20() {
        Orcamento orcamento = new Orcamento();
        for(int i = 0; i < 8; i++){
            orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("25")));
        }
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("20.00"), valor);
    }

    // Valor maior que 500.00
    @Test
    public void deveCalcularDesconto0() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("0.00"), valor);
    }

    @Test
    public void deveCalcularDesconto50() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("501")));
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("50.10"), valor);
    }

    @Test
    public void deveCalcularDesconto60() {
        Orcamento orcamento = new Orcamento();
        for(int i = 0; i < 6; i++){
            orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        }
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        BigDecimal valor = calculadora.calcular(orcamento);
        assertEquals(new BigDecimal("60.00"), valor);
    }

    // Testes de desconto extra
    @Test
    public void deveCalcularDescontoExtraEmAnalise() {
        Orcamento orcamento = new Orcamento();
        for(int i = 0; i < 10; i++){
            orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("10")));
        }
        orcamento.aplicarDescontoExtra();
        assertEquals(new BigDecimal("95.00"), orcamento.getValor());
    }

    @Test
    public void deveCalcularDescontoExtraAprovado() {
        Orcamento orcamento = new Orcamento();
        for(int i = 0; i < 10; i++){
            orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("10")));
        }
        orcamento.aprovar();
        orcamento.aplicarDescontoExtra();
        assertEquals(new BigDecimal("98.00"), orcamento.getValor());
    }

    @Test
    public void deveCalcularDescontoExtraFinalizado() {
        Orcamento orcamento = new Orcamento();
        for(int i = 0; i < 10; i++){
            orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("10")));
        }
        orcamento.aprovar();
        orcamento.finalizar();
        orcamento.aplicarDescontoExtra();
        assertEquals(new BigDecimal("100.00"), orcamento.getValor());
    }

    @Test
    public void deveCalcularDescontoExtraAprovadoEFinalizado() {
        Orcamento orcamento = new Orcamento();
        for(int i = 0; i < 10; i++){
            orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("10")));
        }
        orcamento.aprovar();
        orcamento.aplicarDescontoExtra();
        orcamento.finalizar();
        orcamento.aplicarDescontoExtra();
        assertEquals(new BigDecimal("98.00"), orcamento.getValor());
    }

    @Test
    public void deveCalcularDescontoExtraReprovado() {
        Orcamento orcamento = new Orcamento();
        for(int i = 0; i < 10; i++){
            orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("10")));
        }
        orcamento.reprovar();
        orcamento.aplicarDescontoExtra();
        assertEquals(new BigDecimal("100.00"), orcamento.getValor());
    }

}
