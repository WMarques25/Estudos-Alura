import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        var buscador = new Buscador();

        System.out.println("Digite o CEP: ");
        var cep = scanner.nextLine();
        try{
            Endereco endereco = buscador.buscar(cep);
            System.out.println(endereco);

            var gerador = new GeradorArquivo();
            gerador.gerarArquivo(endereco);

        } catch(RuntimeException e){
            System.out.println("Erro ao buscar o CEP\n" + e.getMessage() + ""); 

        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo\n" + e.getMessage() + "");
        }
        scanner.close();
    }
}
