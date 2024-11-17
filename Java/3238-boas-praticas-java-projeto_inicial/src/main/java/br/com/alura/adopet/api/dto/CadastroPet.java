package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.TipoPet;

public record CadastroPet(
    TipoPet tipo,
    String nome,
    String raca,
    Integer idade,
    String cor,
    Float peso
) {

}
