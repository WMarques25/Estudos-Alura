import br.well.screenmatch.modelos.Filme;
public class ScreenMatch{
    public static void main(String[] args) {
        Filme filme = new Filme();
        filme.setNome("Vingadores: Ultimato");
        filme.setAnoDeLancamento(2019);
        filme.setDuracaoEmMinutos(182);
        filme.setIncluidoNoPlano(true);
        filme.avalia(5);
        filme.avalia(7);
        filme.avalia(8);
        filme.exibeFichaTecnica();
    }
}