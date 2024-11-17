package br.com.alura.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.PetRepository;

@Component
public class ValidarPetDisponivel implements ValidacaoSolocitacaoAdocao{

    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitacaoAdocaoDTO dto){
        var pet = petRepository.getReferenceById(dto.idPet());

        if (pet.getAdotado()) {
            throw new ValidacaoException("Pet já foi adotado!");
        } 
    }
}
