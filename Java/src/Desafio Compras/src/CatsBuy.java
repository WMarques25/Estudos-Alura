import java.util.Collections;
import java.util.Scanner;

import br.well.catsbuy.modelos.Cartao;
import br.well.catsbuy.modelos.Compras;

public class CatsBuy {
    public static void main(String[] args) throws Exception {
        String menu = """

        ******* CatsBuy *******

          1  -  Comprar
          2  -  Listar compras
          3  -  Sair

        ***********************
            """;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o limite do seu cartão: R$");
        double limite = sc.nextDouble();
        Cartao cartao = new Cartao(limite);

        char continuar = 'S';
        while(continuar == 'S') {
            System.out.println(menu);
            System.out.print("Digite a opção desejada: ");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da compra: ");
                    String descricao = sc.next();
                    System.out.print("Digite o valor da compra: ");
                    double valor = sc.nextDouble();

                    Compras compra = new Compras(descricao, valor);
                    boolean compraRealizada = cartao.comprar(compra);
                    if (compraRealizada) {
                        System.out.println("\n\tCompra realizada com sucesso!");

                    } else {

                        System.out.println("\n\tCompra não realizada!\n\tSaldo insuficiente!");
                        continuar = 'N';
                    }
                    break;
                case 2:
                    System.out.println(String.format("""
                    
                            ******* CatsBuy *******
                    
                              Compras realizadas:
                    
                            %s
                            ***********************
                                """, cartao.printCompras()
                        ));
                    break;
                case 3:
                    System.out.println("\n\tObrigado por usar o CatsBuy!\n");
                    continuar = 'N';
                    break;
                default:
                    System.out.println("\n\tOpção inválida!\n");
                    break;
            }
            Collections.sort(cartao.getCompras());
            System.out.println(String.format("""
                    
                            ******* CatsBuy *******
                    
                              Compras realizadas:
                    
                            %s
                            ***********************
                    
                              Saldo do Cartão: 
                            R$%.2f                    
                                """, cartao.printCompras(), cartao.getSaldo()
                        ));
        }

        sc.close();
    }
}
