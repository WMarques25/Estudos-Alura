package br.com.alura.tabelafipe.consulta.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelos(
    List<Dados> modelos
) {

}
