package br.well.screenmatch.calculos;

public class Recomendacao {
    // private String recomendacao;

    public void filtra(Classificavel classificavel){
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Recomendado");
        }else if(classificavel.getClassificacao() >= 2){
            System.out.println("Bem avaliado");
        } else {
            System.out.println("Pouco avaliado");
        }
    }
}
