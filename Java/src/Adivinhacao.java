import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {
    public static void main(String[] args) {
        int chute = -1, tentativa = 0;
        int resposta = new Random().nextInt(100);
        Scanner sc = new Scanner(System.in);

        System.out.println("Tente adivinhar o número aleatório entre 0 e 100.");
        do{
            if (tentativa >= 5) {
                System.out.println("Você não conseguiu, mais sorte na proxima!");
                break;
            }else if (chute == resposta){
                System.out.println("Você acertou!");
                break;
            }
            System.out.println("Tentativas: " + tentativa);
            System.out.print("Chute: ");
            chute = sc.nextInt();
            tentativa++;

        }while(chute != resposta);

        sc.close();
    }
}
