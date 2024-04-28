package br.com.alura.tabelafipe.consulta.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import br.com.alura.tabelafipe.consulta.model.Dados;
import br.com.alura.tabelafipe.consulta.model.DadosModelos;
import br.com.alura.tabelafipe.consulta.model.DadosValor;
import br.com.alura.tabelafipe.consulta.model.DadosVersoes;
import br.com.alura.tabelafipe.consulta.service.ConsumoAPI;
import br.com.alura.tabelafipe.consulta.service.ConverteDados;

public class Consulta {
    private static Scanner scan = new Scanner(System.in);
    private static ConsumoAPI consumoAPI = new ConsumoAPI();
    private static ConverteDados conversor = new ConverteDados();

    public static void consultar() {
        System.out.print("""
            
                Qual o tipo de veiculo para consultar?

                    1 - Motos
                    2 - Carros
                    3 - Caminhões
                
                Digite o número correspondente:  """);
        var json = consumoAPI.obterMarcas(scan.nextInt());
        
        List<Dados> marcas = new ArrayList<>();
        
        System.out.println("\n*-- Marcas --*\n");
        marcas = conversor.obterLista(json, Dados.class);
        marcas.stream()
            .sorted(Comparator.comparing(Dados::codigo))
            .forEach(System.out::print);

        System.out.print("\nDigite o código da marca: ");
        json = consumoAPI.obterModelos(scan.nextInt());

        System.out.println("\n*-- Modelos --*\n");
        var modelosLista = conversor.obterDados(json, DadosModelos.class);
        modelosLista.modelos().stream()
            .sorted(Comparator.comparing(Dados::codigo))
            .forEach(System.out::print);

        System.out.print("\nDigite o código do modelo: ");
        json = consumoAPI.obterVersao(scan.nextInt());

        System.out.println("\n*-- Versões --*\n");
        List<DadosVersoes> versoes = new ArrayList<>();
        versoes = conversor.obterLista(json, DadosVersoes.class);
        versoes.stream()
            .sorted(Comparator.comparing(DadosVersoes::codigo))
            .forEach(System.out::print);
        
        System.out.print("\nDigite o código da versão: ");
        scan.nextLine();
        json = consumoAPI.obterValor(scan.nextLine());

        System.out.println("\n*-- FIPE --*\n");
        var fipe = conversor.obterDados(json, DadosValor.class);
        System.out.println(fipe);
    }

}
