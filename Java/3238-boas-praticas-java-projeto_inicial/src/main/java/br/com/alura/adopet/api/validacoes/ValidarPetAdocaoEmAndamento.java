package br.com.alura.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;

@Component
public class ValidarPetAdocaoEmAndamento implements ValidacaoSolocitacaoAdocao{
    
    @Autowired
    private AdocaoRepository repository;

    public void validar(SolicitacaoAdocaoDTO dto){
        
        var petAdocaoEmAndamento = repository.existsByPetIdAndStatus
            (dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO);

        if (petAdocaoEmAndamento) {
            throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
        }
    }
}
