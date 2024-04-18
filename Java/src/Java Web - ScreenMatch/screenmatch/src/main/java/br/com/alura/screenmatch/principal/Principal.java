package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
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

        System.out.println(dados + "\n\n");

        List<DadosTemporada> temporadas = new ArrayList<>();
		for	(int i = 1; i <= dados.totalTempordas(); i++) {
			json = consumoAPI.obterDados(ENDERECO + nomeSerie + "&Season="+i);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

    }
}
