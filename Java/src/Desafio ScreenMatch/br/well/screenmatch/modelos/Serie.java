package br.well.screenmatch.modelos;

public class Serie extends Titulos{
    private int temporadas;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;
    private boolean ativa;

    @Override
    public void exibeFichaTecnica() {
        System.out.println(String.format("""
            Nome: %s (%d)
            Temporadas: %d
            Episódios por temporada: %d
            Maratonar: %.0f min
            Avaliação: %.1f (%d avaliações)
            Incluído no plano: %s
            """, getNome(), getAnoDeLancamento(), getTemporadas(), getEpisodiosPorTemporada(),getDuracaoEmMinutos(), pegaMedia(),
             getTotalDeAvaliacoes(), isIncluidoNoPlano() ? "Sim" : "Não"
        ));
    }

    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }
    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }
    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }
    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }
    public boolean isAtiva() {
        return ativa;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public double getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }

}
