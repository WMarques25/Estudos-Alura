package br.com.alura.tabelafipe.consuta.principal;

import java.util.Scanner;

import br.com.alura.tabelafipe.consuta.service.ConsumoAPI;

public class Consulta {
    private static Scanner scan = new Scanner(System.in);
    private static ConsumoAPI consumoAPI = new ConsumoAPI();

    public static void consultar() {
        System.out.print("""
                Qual o tipo de veiculo para consultar?
                    1 - Motos
                    2 - Carros
                    3 - Caminhões
                """);
        consumoAPI.obterMarcas(scan.nextInt());
    }

}
