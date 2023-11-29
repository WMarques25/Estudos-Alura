package br.com.alura;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutor();
        Scanner sc = new Scanner(System.in);

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                exibirMenu();

                String textoDigitado = sc.nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                switch (opcaoEscolhida) {
                    case 1 -> executor.execute(new ListarAbrigoCommand());
                    case 2 -> executor.execute(new CadastrarAbrigoCommand());
                    case 3 -> executor.execute(new ListarPetAbrigoCommand());
                    case 4 -> executor.execute(new ImportarPetAbrigoCommand());
                    case 5 -> System.exit(0);    
                    default -> {System.out.println("NÚMERO INVÁLIDO!"); opcaoEscolhida = 0;}
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }

    private static void exibirMenu(){
        System.out.println("""
            \nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:
                1 -> Listar abrigos cadastrados
                2 -> Cadastrar novo abrigo
                3 -> Listar pets do abrigo
                4 -> Importar pets do abrigo
                5 -> Sair"""
            );
    }
}
