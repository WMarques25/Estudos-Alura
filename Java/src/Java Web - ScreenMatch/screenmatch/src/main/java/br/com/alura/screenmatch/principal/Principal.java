package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
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

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0){
            var menu = """
                    1 - Buscar série
                    2 - Buscar episódio
                    3 - Listar séries buscadas

                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1 -> buscarSerie();
                case 2 -> buscarEpisodioPorSerie();
                case 3 -> listarSeriesBuscadas();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void buscarSerie() {
        DadosSerie dados = getDadosSerie();
        var serie = new Serie(dados);
        // dadosSeries.add(dados);
        repo.save(serie);
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {

        System.out.println("Digite o nome da série: ");
        var nomeSerie = leitura.nextLine().replace(" ", "+");
        var json = consumoAPI.obterDados(ENDERECO + nomeSerie + "&apikey=" + System.getenv("API_IMDB_KEY"));
        var dados = conversor.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie() {
        DadosSerie dados = getDadosSerie();

        List<DadosTemporada> temporadas = new ArrayList<>();
		for	(int i = 1; i <= dados.totalTempordas(); i++) {
			var json = consumoAPI.obterDados(ENDERECO + dados.titulo().replace(" ", "+") + "&Season="+i);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

    }

    private void listarSeriesBuscadas() {
        List<Serie> series = repo.findAll();
        series.stream()
            .sorted(Comparator.comparing(Serie::getGenero))
            .forEach(System.out::println);
    }

    public Principal(SerieRepository repository){
        this.repo = repository;
    }
}
