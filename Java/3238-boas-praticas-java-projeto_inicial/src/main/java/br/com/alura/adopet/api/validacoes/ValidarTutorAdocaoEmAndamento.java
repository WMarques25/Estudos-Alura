package br.com.alura.adopet.api.validacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;

@Component
public class ValidarTutorAdocaoEmAndamento implements ValidacaoSolocitacaoAdocao{

    @Autowired
    private AdocaoRepository repository;

    @Autowired
    private TutorRepository tutorRepository;


    public void validar(SolicitacaoAdocaoDTO dto){
        List<Adocao> adocoes = repository.findAll();
        var tutor = tutorRepository.getReferenceById(dto.idTutor());

        for (Adocao a : adocoes) {
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
            }
        }
    }
}
