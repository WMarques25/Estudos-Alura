import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {

        boolean sair = false;
        Scanner teclado = new Scanner(System.in);
        String dadosCliente = """
                ***********************
                Dados iniciais do cliente:
                
                Nome: %s
                Tipo conta: %s
                Saldo inicial: %.2f
                ***********************
                """;
         
        String menu =  """
            *** Operações ***

            1- Consultar saldos
            2- Depositar valor
            3- Transferir valor
            4- Sair

            Digite a opção desejada: """ + " ";
        double saldo = 0;
        String conta = "Corrente";
        String nomeCliente = "Wellington Marques";
        
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println(String.format(dadosCliente, nomeCliente, conta, saldo));
        
        while(!sair){
            
            System.out.print(menu);
            int op = teclado.nextInt();

            switch(op){
                case 1:
                    Consultar(saldo);
                    break;
                
                case 2:

                    saldo = Depositar(saldo, teclado);
                    break;

                case 3:
                    saldo = Transferir(saldo, teclado);
                    break;

                case 4:
                    sair = Sair();
                    break;

                default:
                    System.out.println("\nOpção Inválida.\n");
                    
            }
            
        }
        teclado.close();
    }
    
    private static void Consultar(double saldo) {
        System.out.println(String.format("\nSaldo Atual: R$%.2f\n", saldo));
    }

    private static double Depositar(double saldo, Scanner teclado) {
        System.out.print("Digite a quantia que desja depositar: R$");
        double deposito = teclado.nextDouble();
        
        if(deposito > 0){
            saldo += deposito;
            System.out.println(String.format("\nSaldo Atualizado: R$%.2f\n", saldo));
            return saldo;
        }else{
            System.out.println("\nValor inválido.\n");
            return saldo;
        }
    }

    private static double Transferir(double saldo, Scanner teclado) {
        System.out.print("Digite a quantia que desja transferir: R$");
        double transferido = teclado.nextDouble();

        if(transferido < saldo && transferido >= 0){
            saldo -= transferido;
            System.out.println(String.format("\nSaldo Atualizado: R$%.2f\n", saldo));
            return saldo;
        }else{
            System.out.println("\nSaldo insuficiente.\n");
            return saldo;
        }
    }
    
    private static boolean Sair() {
        return true;
    }
}
