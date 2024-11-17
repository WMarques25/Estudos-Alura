package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;

public interface ValidacaoSolocitacaoAdocao {

    void validar(SolicitacaoAdocaoDTO dto);
}
