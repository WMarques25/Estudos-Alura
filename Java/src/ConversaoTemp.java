import java.util.Scanner;

public class ConversaoTemp {
    public static void main(String[] args) throws Exception {
        // Variaveis
        float tc;
        double tf;
        Scanner sc = new Scanner(System.in);
        
        // Entrada + Calculo
        System.out.print("Insira um valor: ");
        tc = sc.nextFloat();
        tf = (tc * 1.8) + 32;

        // Saida
        System.out.println(String.format("%.2fºC = %.2fºF", tc,tf));
        sc.close();

    }
}
