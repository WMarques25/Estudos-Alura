package br.well.screenmatch.modelos;

import br.well.screenmatch.calculos.Classificavel;

public class Episodio implements Classificavel{
    private int numero;
    // private int duracaoEmMinutos;
    private String nome;
    private Serie serie;
    private int totalDeVisualizacoes;


    public int getTotalDeVisualizacoes() {
        return totalDeVisualizacoes;
    }



    public void setTotalDeVisualizacoes(int totalDeVisualizacoes) {
        this.totalDeVisualizacoes = totalDeVisualizacoes;
    }



    @Override
    public int getClassificacao() {
        if (totalDeVisualizacoes > 100) {
            return 4;
        } else {
            return 2;
        }
    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

}
