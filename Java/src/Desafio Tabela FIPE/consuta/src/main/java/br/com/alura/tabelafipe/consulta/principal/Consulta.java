package br.com.alura.tabelafipe.consulta.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import br.com.alura.tabelafipe.consulta.model.DadosMarcas;
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
                
                Digite o número correspondente: """);
        var json = consumoAPI.obterMarcas(scan.nextInt());
        
        List<DadosMarcas> marcas = new ArrayList<>();
        // DadosMarcas dadosMarcas = conversor.obterDados(json, DadosMarcas.class);
        marcas = conversor.obterLista(json, DadosMarcas.class);
        marcas.stream()
            .sorted(Comparator.comparing(DadosMarcas::codigo))
            .forEach(System.out::print);

        System.out.print("Digite o código da marca: ");
        json = consumoAPI.obterModelos(scan.nextInt());
        System.out.println(json);
    }

}
