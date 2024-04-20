package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {
        System.out.println("Digite o nome da série: ");
        var nomeSerie = leitura.nextLine().replace(" ", "+");
        var json = consumoAPI.obterDados(ENDERECO + nomeSerie);
        var dados = conversor.obterDados(json, DadosSerie.class);

        // System.out.println(dados + "\n\n");

        List<DadosTemporada> temporadas = new ArrayList<>();
		for	(int i = 1; i <= dados.totalTempordas(); i++) {
			json = consumoAPI.obterDados(ENDERECO + nomeSerie + "&Season="+i);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		// temporadas.forEach(System.out::println);

        // for(int i = 0; i< dados.totalTempordas(); i++){
        //     List<DadosEpisodio> episodiosTemprada = temporadas.get(i).episodios();
        //     for(int j = 0; j<episodiosTemprada.size(); j++){
        //         System.out.println(episodiosTemprada.get(j).titulo());
        //     }
        // }
        // temporadas.forEach(t -> t.episodios().
        //         forEach(e -> System.out.println(e.titulo())));

        // List<DadosEpisodio> dadosEpisodios = temporadas.stream()
        //     .flatMap(t -> t.episodios().stream())
        //     .collect(Collectors.toList());

        // System.out.println("Os 5 melhores episódios são: ");
        // dadosEpisodios.stream()
        //     .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
        //     .peek(e -> System.out.println("Filtro N/A \n" + e))
        //     .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
        //     .peek(e -> System.out.println("Ordenação \n" + e))
        //     .limit(5)
        //     .peek(e -> System.out.println("Limit \n" + e))
        //     .map(e -> e.titulo().toUpperCase())
        //     .peek(e -> System.out.println("Map \n" + e))
        //     .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
            .flatMap(t -> t.episodios().stream()
                .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());
        
        episodios.forEach(System.out::println);

        // System.out.println("Digite o título do episódio que deseja pesquisar: ");
        // var pesquisaTitulo = leitura.nextLine();
        // Optional<Episodio> episodioBuscado = episodios.stream()
        //     .filter(e -> e.getTitulo().toUpperCase().contains(pesquisaTitulo.toUpperCase()))
        //     .findFirst();
        
        // if(episodioBuscado.isPresent()){
        //     System.out.println("Temp: " + episodioBuscado.get().getTemporada());
        // } else {
        //     System.out.println("Episódio não encontrado");
        // }

        // System.out.println("A partir de que ano deseja ver os episódios? ");
        // var ano = leitura.nextInt();
        // leitura.nextLine();

        // LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        // DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // episodios.stream()
        //     .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
        //     .forEach(e -> {
        //         System.out.println("""
        //             Temporada: %d
        //             Título: %s
        //             Número do episódio: %d
        //             Avaliação: %.2f
        //             Data de lançamento: %s
        //                 """.formatted(e.getTemporada(), e.getTitulo(), 
        //                 e.getNumeroEpisodio(), e.getAvaliacao(), 
        //                 e.getDataLancamento().format(formatador))
        //             );
        //     });


        Map<Integer, Double> avaliacaoPorTemporada = episodios.stream()
            .filter(e -> e.getAvaliacao() >= 0.0)
            .collect(Collectors.groupingBy(Episodio::getTemporada,
                Collectors.averagingDouble(Episodio::getAvaliacao)));

        System.out.println("Avaliação média por temporada: " + avaliacaoPorTemporada);
    }
}
