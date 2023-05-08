package br.well.musicats.principal;

import br.well.musicats.modelos.MinhasPreferidas;
import br.well.musicats.modelos.Musica;
import br.well.musicats.modelos.Podcasts;

public class MusiCats {
    public static void main(String[] args) {
        Musica musica = new Musica();
        musica.setTitulo("Please Be Quiet");
        musica.setArtista("Spam Alert!");
        musica.setAlbum("S.P.A.M.");

        for (int i = 0; i < 1000; i++) {
            musica.reproduzir();
        }
        for (int i = 0; i < 50; i++) {
            musica.curtir();
        }

        Podcasts podcast = new Podcasts();
        podcast.setTitulo("The WellCast");
        podcast.setApresentador("Wellington");
        podcast.setDescricao("Um podcast sobre programação");
        
        for (int i = 0; i < 500; i++) {
            podcast.reproduzir();
        }
        for (int i = 0; i < 50; i++) {
            podcast.curtir();
        }

        MinhasPreferidas minhasPreferidas = new MinhasPreferidas();
        minhasPreferidas.inclui(musica);
        minhasPreferidas.inclui(podcast);
    }
}
