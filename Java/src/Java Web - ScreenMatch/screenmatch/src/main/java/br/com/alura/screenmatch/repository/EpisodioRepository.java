package br.com.alura.screenmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.screenmatch.model.Episodio;

public interface EpisodioRepository extends JpaRepository<Episodio, Long>{

}
