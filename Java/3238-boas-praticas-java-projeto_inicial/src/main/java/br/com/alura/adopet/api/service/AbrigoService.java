package br.com.alura.adopet.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.adopet.api.dto.AbrigoDTO;
import br.com.alura.adopet.api.dto.CadastrarAbrigoDTO;
import br.com.alura.adopet.api.dto.PetsDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    @Autowired
    private PetRepository petRepository;

    public List<AbrigoDTO> listar(){
        return repository.findAll()
            .stream().map(AbrigoDTO::new).toList();
    }

    public void cadastrar(CadastrarAbrigoDTO dto){
        boolean JaCadastrado = repository
            .existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());

        if (JaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        }
        repository.save(new Abrigo(dto));
    }

    public List<PetsDTO> listarPets(String idOuNome){
        var abrigo = carregarAbrigo(idOuNome);

        return petRepository.findByAbrigo(abrigo)
            .stream().map(PetsDTO::new).toList();
    }

    public Abrigo carregarAbrigo(String idOuNome){
        Optional<Abrigo> optional;
        try {
            Long id = Long.parseLong(idOuNome);
            optional = repository.findById(id);
        } catch (NumberFormatException e) {
            optional = repository.findByNome(idOuNome);
        }
        
        return optional.orElseThrow(
            () -> new ValidacaoException("Abrigo não encontrado")
        );
    }
}
