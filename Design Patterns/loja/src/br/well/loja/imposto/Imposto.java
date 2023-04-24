package br.well.loja.imposto;

import java.math.BigDecimal;

import br.well.loja.orcamento.Orcamento;

public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
