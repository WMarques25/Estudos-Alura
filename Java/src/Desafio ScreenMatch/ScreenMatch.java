import java.util.ArrayList;

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

        Filme filme3 = new Filme();
        filme3.setNome("Vingadores: Era de Ultron");
        filme3.setAnoDeLancamento(2015);
        filme3.setDuracaoEmMinutos(141);
        filme3.setIncluidoNoPlano(true);
        filme3.avalia(8);
        filme3.avalia(4);
        filme3.avalia(1);
        filme3.exibeFichaTecnica();

        Filme filme4 = new Filme();
        filme4.setNome("Vingadores");
        filme4.setAnoDeLancamento(2012);
        filme4.setDuracaoEmMinutos(143);
        filme4.setIncluidoNoPlano(true);
        filme4.avalia(8);
        filme4.avalia(6);
        filme4.avalia(9);
        filme4.exibeFichaTecnica();

        ArrayList<Filme> listaDeFilmes = new ArrayList<Filme>();
        listaDeFilmes.add(filme);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);
        listaDeFilmes.add(filme4);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Filme 1: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
    }
}