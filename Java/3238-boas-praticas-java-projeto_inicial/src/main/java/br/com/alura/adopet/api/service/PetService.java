package br.com.alura.adopet.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.adopet.api.dto.CadastroPet;
import br.com.alura.adopet.api.dto.PetsDTO;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<PetsDTO> listarTodosDisponiveis(){
        return repository.findAllByAdotadoFalse()
            .stream().map(PetsDTO::new).toList();
    }

    public void cadastrarPet(CadastroPet dto, Abrigo abrigo) {
        repository.save(new Pet(dto, abrigo));
    }
}
