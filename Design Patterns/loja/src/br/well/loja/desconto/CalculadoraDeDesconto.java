package br.well.loja.desconto;

import java.math.BigDecimal;

import br.well.loja.orcamento.Orcamento;

public class CalculadoraDeDesconto {
    public BigDecimal calcular(Orcamento orcamento) {
        Desconto descontos = 
                new DescontoParaMaisDe5Itens(
                    new DescontoParaValorMaior500(
                        new SemDesconto()));

        return descontos.calcular(orcamento);
    }
}
