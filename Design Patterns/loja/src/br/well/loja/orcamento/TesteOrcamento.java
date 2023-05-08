package br.well.loja.orcamento;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class TesteOrcamento {
    @Test
    public void deveCalcularValorDoOrcamento() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("50")));
        
        OrcamentoProxy proxy = new OrcamentoProxy(orcamento);

        BigDecimal valor = proxy.getValor();
        
        assertEquals(new BigDecimal("150"), valor);
    }

    @Test
    public void deveCalcularValorComOrcamentoAntigo() {
        Orcamento antigo = new Orcamento();
        antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
        antigo.adicionarItem(new ItemOrcamento(new BigDecimal("50")));
        antigo.reprovar();
        
        Orcamento novo = new Orcamento();
        novo.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        novo.adicionarItem(antigo);

        OrcamentoProxy proxy = new OrcamentoProxy(novo);
        
        assertEquals(new BigDecimal("350"), proxy.getValor());
    }
}
