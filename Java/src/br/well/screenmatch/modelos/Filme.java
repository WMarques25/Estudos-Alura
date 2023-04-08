package br.well.screenmatch.modelos;

import br.well.screenmatch.calculos.Classificavel;

public class Filme extends Titulos implements Classificavel{
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
    
}
