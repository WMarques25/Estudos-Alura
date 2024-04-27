package br.com.alura.tabelafipe.consulta.model;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelos(
    List<Dados> modelos
) {
        
    @Override
    public String toString() {
        return modelos.forEach;
    }

}
