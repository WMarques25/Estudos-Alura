package br.com.alura.screenmatch.dto;

import java.time.LocalDate;

import br.com.alura.screenmatch.model.Episodio;

public record EpisodioDTO(
    Long id,
    Integer temporada,
    String titulo,
    Integer numeroEpisodio,
    Double avaliacao,
    LocalDate dataLancamento
) {
    public EpisodioDTO(Episodio e){
        this(
            e.getId(), 
            e.getTemporada(), 
            e.getTitulo(), 
            e.getNumeroEpisodio(), 
            e.getAvaliacao(), 
            e.getDataLancamento()
        );
    }

}
