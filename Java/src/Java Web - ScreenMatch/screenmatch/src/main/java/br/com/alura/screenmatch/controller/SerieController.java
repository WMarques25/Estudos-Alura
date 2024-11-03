package br.com.alura.screenmatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.service.SerieService;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService servico;

    @GetMapping
    public List<SerieDTO> obterSeries(){
        return servico.obterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> retornarInicio(){
        return servico.obterTop5();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> lancamentos(){
        return servico.obterLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDTO obterPorId(@PathVariable Long id){
        return servico.obterPorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obterTemporadas(@PathVariable Long id){
        return servico.obterTemoradas(id);
    }

    @GetMapping("/{id}/temporadas/{temp}")
    public List<EpisodioDTO> obterTemporadas(@PathVariable Long id, @PathVariable Long temp){
        return servico.obterTemporadaPorId(id, temp);
    }

    @GetMapping("/categoria/{categoria}")
    public List<SerieDTO> obterPorCategoria(@PathVariable String categoria){
        return servico.obterPorCategoria(categoria);
    }

}
