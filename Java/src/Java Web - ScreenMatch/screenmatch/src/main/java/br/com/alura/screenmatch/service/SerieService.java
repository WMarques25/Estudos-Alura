package br.com.alura.screenmatch.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDTO> obterTodasAsSeries(){
        return converterDTO(repository.findAll());
    }

    public List<SerieDTO> obterTop5() {
        return converterDTO(repository.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SerieDTO> obterLancamentos() {
        return converterDTO(repository.lancamentos());
    }

    public List<EpisodioDTO> obterTemoradas(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if (serie.isPresent()) {
            return serie.get().getEpisodios().stream()
                .map(e -> new EpisodioDTO(e)).collect(Collectors.toList());
        }
        return null;
    }

    public SerieDTO obterPorId(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if (serie.isPresent()) {
            return new SerieDTO(serie.get());
        }
        return null;   
    }
    
    private List<SerieDTO> converterDTO(List<Serie> series){
        return series.stream().map(s -> new SerieDTO(s))
        .collect(Collectors.toList());
    }
        
    private List<EpisodioDTO> converterEpDTO(List<Episodio> eps){
        return eps.stream().map(e -> new EpisodioDTO(e))
        .collect(Collectors.toList());
    }

    public List<EpisodioDTO> obterTemporadaPorId(Long id, Long temp) {
        return converterEpDTO(repository.epsodiosPorTemp(id, temp));
    }

    public List<SerieDTO> obterPorCategoria(String categoria) {
        var categ = Categoria.fromStringBR(categoria);

        return converterDTO(repository.findByGenero(categ));
    }
}
