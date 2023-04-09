package br.well.screenmatch.principal;

import java.util.ArrayList;

import br.well.screenmatch.modelos.Filme;
import br.well.screenmatch.modelos.Serie;
import br.well.screenmatch.modelos.Titulos;

public class PrincipalComListas {
    public static void main(String[] args) {
        var filme = new Filme("Vingadores: Ultimato", 
                2019, 
                true);
        filme.avalia(8);
        
        var filme2 = new Filme("Vingadores: Guerra Infinita", 
                2018, 
                true);
        filme2.avalia(9);

        var filme3 = new Filme("Vingadores: Era de Ultron", 
                2015, 
                true);
        filme3.avalia(7);

        var filme4 = new Filme("Os Vingadores", 
                2012, 
                true);
        filme4.avalia(10);

        Serie theWitcher = new Serie("The Witcher", 2019, true);
        
        ArrayList<Titulos> assistidos = new ArrayList<>();
        assistidos.add(filme);
        assistidos.add(filme2);
        assistidos.add(filme3);
        assistidos.add(filme4);
        assistidos.add(theWitcher);

        for (Titulos titulo : assistidos) {
            System.out.print(titulo);
            if (titulo instanceof Filme f)
                System.out.println("\nClassificação: " + f.getClassificacao());
        }
    }
}
