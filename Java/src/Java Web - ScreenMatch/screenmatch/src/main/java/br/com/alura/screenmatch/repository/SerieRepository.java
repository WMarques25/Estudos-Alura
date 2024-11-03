package br.com.alura.screenmatch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long>{

    Optional<Serie> findByTituloContainingIgnoreCase(String titulo);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String ator, Double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria genero);

    List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int totalTemporadas, double avaliacao);

    @Query(value = """
        select s from Serie s
            where s.totalTemporadas <= :temp
            and s.avaliacao >= :avaliacao
    """)
    List<Serie> seriesPorTempEAvaliacao(int temp, double avaliacao);

    @Query(value = """
            Select e From Serie S
                Join S.episodios e
                Where e.titulo Ilike %:trecho%
                Order By S.titulo, e.temporada, e.numeroEpisodio
            """)
    List<Episodio> episodiosPorTrecho(String trecho);

    @Query("""
            Select e From Serie S
                Join S.episodios e
                Where S = :serie
                Order By e.avaliacao Desc Limit 5
            """)
    List<Episodio> topEpisodiosPorSerie(Serie serie);

    @Query("""
            Select e From Serie S
                Join S.episodios e
                Where S = :serie
                And Year(e.dataLancamento) >= :ano
            """)
    List<Episodio> esodiosPorSerieEAno(int ano, Serie serie);

    @Query("""
            Select S From Serie S, Episodio e
                where S = e.serie
                Group By S
                Order By Max(e.dataLancamento) Desc Limit 5
            """)
    List<Serie> lancamentos();

    @Query("""
            Select e From Serie s
                Join s.episodios e
                Where s.id = :id
                And e.temporada = :temp
            """)
    List<Episodio> epsodiosPorTemp(Long id, Long temp);
}
