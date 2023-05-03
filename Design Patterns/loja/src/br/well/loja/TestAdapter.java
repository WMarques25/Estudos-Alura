package br.well.loja;

import java.math.BigDecimal;

import br.well.loja.http.JavaHttpClient;
import br.well.loja.orcamento.Orcamento;
import br.well.loja.orcamento.RegistroDeOrcamento;

public class TestAdapter {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(BigDecimal.TEN, 1);
        orcamento.aprovar();
        orcamento.finalizar();

        RegistroDeOrcamento registro = new RegistroDeOrcamento(new JavaHttpClient());
        registro.registrar(orcamento);
    }
}
