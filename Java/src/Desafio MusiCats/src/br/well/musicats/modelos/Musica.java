package br.well.musicats.modelos;

public class Musica extends Audio{
    private String artista;
    private String album;
    private String genero;

    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public double getClassificacao() {
        if(this.getTotalReproducoes() > 500)
            return 10.0;
        else
            return 7.0;
    }

}
