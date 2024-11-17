package br.com.alura.adopet.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.adopet.api.dto.AtualizarTutor;
import br.com.alura.adopet.api.dto.CadastroTutor;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public void cadastrar(CadastroTutor dto){
        boolean tutorExiste = repository.existsByTelefoneOrEmail(dto.telefone(), dto.email());

        if (tutorExiste) {
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");
        }
        repository.save(new Tutor(dto));
    
    }

	public void atualizar(AtualizarTutor dto) {
        var tutor = repository.getReferenceById(dto.id());
        tutor.atualizar(dto);
	}
}
