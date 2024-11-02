package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private List<DadosSerie> dadosSeries = new ArrayList<>();

    private SerieRepository repo;

    private List<Serie> series = new ArrayList<>();

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0){
            var menu = """

                    1 - Buscar série
                    2 - Buscar episódio
                    3 - Listar séries buscadas
                    4 - Buscar Serie por nome
                    5 - Buscar Series com Ator
                    6 - Top 5 Series
                    7 - Buscar por Categoria
                    8 - Buscar por Max de Temporadas e Avaliação Minima

                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1 -> buscarSerie();
                case 2 -> buscarEpisodioPorSerie();
                case 3 -> listarSeriesBuscadas();
                case 4 -> buscarSeriePorTitulo();
                case 5 -> buscarSeriePorAtor();
                case 6 -> buscarTop5Series();
                case 7 -> buscarPorCategoria();
                case 8 -> buscarPorTempEAvaliacao();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void buscarSeriePorTitulo() {
        System.out.println("Escolha uma Serie pelo nome: ");
        var nome = leitura.nextLine();
        Optional<Serie> serie = repo.findByTituloContainingIgnoreCase(nome);

        if (serie.isPresent()) {
            System.out.println("Dados da serie: \n" + serie.get());
        }else{
            System.out.println("Série não encontrada!");
        }
    }
                
    private void buscarSerie() {
        DadosSerie dados = getDadosSerie();
        var serie = new Serie(dados);
        // dadosSeries.add(dados);
        repo.save(serie);
        System.out.println(dados);
    }

    private void buscarPorCategoria(){
        System.out.println("\nDigite o nome da categoria");
        var genero = leitura.nextLine();
        var categoria = Categoria.fromStringBR(genero);

        List<Serie> series = repo.findByGenero(categoria);

        System.out.println("Series de " + categoria);
        series.forEach(s -> 
            System.out.println(s.getTitulo() + ": " + s.getAvaliacao() 
            + "\n\t" + s.getSinopse()));

    }

    private void buscarTop5Series(){
        List<Serie> series = repo.findTop5ByOrderByAvaliacaoDesc();
        series.forEach(s ->
            System.out.println(s.getTitulo() + ": " + s.getAvaliacao()));
    }

    private DadosSerie getDadosSerie() {

        System.out.println("Digite o nome da série: ");
        var nomeSerie = leitura.nextLine().replace(" ", "+");
        var json = consumoAPI.obterDados(ENDERECO + nomeSerie + "&apikey=" + System.getenv("API_IMDB_KEY"));
        var dados = conversor.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie() {
        listarSeriesBuscadas();
        System.out.println("Digite o nome da série: ");
        var nomeSerie = leitura.nextLine();

        Optional<Serie> serie = repo.findByTituloContainingIgnoreCase(nomeSerie);

        if (serie.isPresent()) {
            var serieEncontrada = serie.get(); 

            List<DadosTemporada> temporadas = new ArrayList<>();
            for	(int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumoAPI.obterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&Season="+i + "&apikey=" + System.getenv("API_IMDB_KEY"));
                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream().flatMap(
                d -> d.episodios().stream()
                    .map(e -> new Episodio(d.numero(), e)))
                .collect(Collectors.toList());
            serieEncontrada.setEpisodios(episodios);

            repo.save(serieEncontrada);
            
        } else{
            System.out.println("Série não Encontrada.");
        }

    }

    private void buscarPorTempEAvaliacao(){
        System.out.println("\nDigite o Maximo de Temporadas: ");
        var temp = leitura.nextInt();
        leitura.nextLine();
        System.out.println("\nDigite a avaliação Minima: ");
        var ava = leitura.nextDouble();
        leitura.nextLine();

        List<Serie> ser = repo.seriesPorTempEAvaliacao(temp, ava);

        System.out.println("Series: ");
        ser.forEach(s ->
            System.out.println(s.getTitulo() + ":\n\t" + s.getSinopse()));

    }

    private void buscarSeriePorAtor(){
        System.out.println("\nDigite o nome do ator: ");
        var ator = leitura.nextLine();
        System.out.println("Digite a avaliaçao minima: ");
        var ava = leitura.nextDouble();
        List<Serie> series = repo.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(ator, ava);

        System.out.println(ator + ": ");
        series.forEach(s -> 
            System.out.println(s.getTitulo() + "\n\t" + s.getSinopse() + "\n"));
    }

    private void listarSeriesBuscadas() {
        series = repo.findAll();
        series.stream()
            .sorted(Comparator.comparing(Serie::getGenero))
            .forEach(System.out::println);
    }

    public Principal(SerieRepository repository){
        this.repo = repository;
    }
}
