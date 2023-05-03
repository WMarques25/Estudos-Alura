package br.well.loja.imposto;

import java.math.BigDecimal;

import br.well.loja.orcamento.Orcamento;

public abstract class Imposto {

    private Imposto outro;
    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

    public Imposto(Imposto outro) {
        this.outro = outro;
    }

    public BigDecimal calcular(Orcamento orcamento){
        BigDecimal valorImposto = realizarCalculo(orcamento);
        BigDecimal valorOutroImposto = BigDecimal.ZERO;
        if(outro != null){
            valorOutroImposto = outro.realizarCalculo(orcamento);
        }
        return valorImposto.add(valorOutroImposto);
    }
}
