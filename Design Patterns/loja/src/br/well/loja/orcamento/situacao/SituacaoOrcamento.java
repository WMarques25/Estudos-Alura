package br.well.loja.orcamento.situacao;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.well.loja.DomainException;
import br.well.loja.orcamento.Orcamento;

public abstract class SituacaoOrcamento {

    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    }

    public void aprovar(Orcamento orcamento) {
        throw new DomainException("Orcamento não pode ser aprovado!");
    }

    public void reprovar(Orcamento orcamento) {
        throw new DomainException("Orcamento não pode ser reprovado!");
    }

    public void finalizar(Orcamento orcamento) {
        throw new DomainException("Orcamento não pode ser reprovado!");
    }

}
