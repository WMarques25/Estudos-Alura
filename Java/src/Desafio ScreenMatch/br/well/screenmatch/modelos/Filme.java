package br.well.screenmatch.modelos;

import calculos.Classificavel;

public class Filme extends Titulos implements Classificavel{
    public Filme(String nome, int anoDeLancamento, boolean incluidoNoPlano) {
        super(nome, anoDeLancamento, incluidoNoPlano);
    }

    private String diretor;

    public String getDiretor() {
        return this.diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int)pegaMedia() / 2;
    }
    
    @Override
    public String toString() {
        return "\nFilme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}
