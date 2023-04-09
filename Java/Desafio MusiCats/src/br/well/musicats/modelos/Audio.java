package br.well.musicats.modelos;

public class Audio {
    private String titulo;
    private int totalReproducoes;
    private int totalCurtidas;
    private double classificacao;
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getTotalReproducoes() {
        return totalReproducoes;
    }
    public int getTotalCurtidas() {
        return totalCurtidas;
    }    
    public void reproduzir() {
        this.totalReproducoes++;
    }
    public void curtir() {
        this.totalCurtidas++;
    }
    public double getClassificacao() {
        return classificacao;
    }    
}
