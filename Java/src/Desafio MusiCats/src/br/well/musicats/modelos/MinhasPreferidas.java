package br.well.musicats.modelos;

public class MinhasPreferidas {
    public void inclui(Audio audio) {
        if(audio.getClassificacao() >= 9.0)
            System.out.println("Adicionando " + audio.getTitulo() + " às minhas preferidas");
        else
            System.out.println("Não vou adicionar " + audio.getTitulo() + " às minhas preferidas");
    }
}
