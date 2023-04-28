package br.well.loja.orcamento.situacao;

import br.well.loja.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento{

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }

}
