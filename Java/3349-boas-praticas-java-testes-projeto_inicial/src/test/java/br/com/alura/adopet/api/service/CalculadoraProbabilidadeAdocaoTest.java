package br.com.alura.adopet.api.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;

public class CalculadoraProbabilidadeAdocaoTest {
    @Test
    void cenario01() {
        // idade 4 anos e 4kg - ALTA
        var abrigo = new Abrigo(new CadastroAbrigoDto("Abrigo feliz", 
            "9499999", "abrigofeliz@email.com.br"));

        var pet = new Pet(new CadastroPetDto(TipoPet.GATO, "Miau",
            "Siames", 4, "Cinza", 4.0f), abrigo); 

        var calculadora = new CalculadoraProbabilidadeAdocao();
        var probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }

    @Test
    void cenario02() {
        // idade 15 anos e 4kg - ALTA
        var abrigo = new Abrigo(new CadastroAbrigoDto("Abrigo feliz", 
            "9499999", "abrigofeliz@email.com.br"));

        var pet = new Pet(new CadastroPetDto(TipoPet.GATO, "Miau",
            "Siames", 15, "Cinza", 4.0f), abrigo); 

        var calculadora = new CalculadoraProbabilidadeAdocao();
        var probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
    }
}
