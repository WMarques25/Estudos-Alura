import br.well.screenmatch.calculos.CalculadoraDeTempo;
import br.well.screenmatch.calculos.Recomendacao;
import br.well.screenmatch.modelos.Episodio;
import br.well.screenmatch.modelos.Filme;
import br.well.screenmatch.modelos.Serie;

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

        Serie theWitcher = new Serie();
        theWitcher.setNome("The Witcher");
        theWitcher.setAnoDeLancamento(2019);
        theWitcher.setTemporadas(2);
        theWitcher.setEpisodiosPorTemporada(8);
        theWitcher.setMinutosPorEpisodio(60);
        theWitcher.setIncluidoNoPlano(true);
        theWitcher.avalia(9);
        theWitcher.avalia(8);
        theWitcher.avalia(7);
        theWitcher.exibeFichaTecnica();

        Filme filme2 = new Filme();
        filme2.setNome("Vingadores: Guerra Infinita");
        filme2.setAnoDeLancamento(2018);
        filme2.setDuracaoEmMinutos(160);
        filme2.setIncluidoNoPlano(true);
        filme2.avalia(8);
        filme2.avalia(9);
        filme2.avalia(10);
        filme2.exibeFichaTecnica();

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme);
        calculadora.inclui(filme2);
        calculadora.inclui(theWitcher);
        System.out.println("Tempo para maratonar sua lista: " + calculadora.getTempoTotal() + " horas");

        Recomendacao recomendacao = new Recomendacao();
        recomendacao.filtra(filme2);

        Episodio episodio = new Episodio();
        episodio.setNome("Episodio 1");
        episodio.setSerie(theWitcher);
        episodio.setNumero(1);
        episodio.setTotalDeVisualizacoes(101);
        recomendacao.filtra(episodio);

        
    }
}