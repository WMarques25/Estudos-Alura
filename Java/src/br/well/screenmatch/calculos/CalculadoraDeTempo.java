package br.well.screenmatch.calculos;

import br.well.screenmatch.modelos.Titulos;

public class CalculadoraDeTempo {
    private double tempoTotal;

    public double getTempoTotal() {
        
        return tempoTotal/60;

    }

    public void inclui(Titulos t){
        tempoTotal += t.getDuracaoEmMinutos();
    }
    
}
