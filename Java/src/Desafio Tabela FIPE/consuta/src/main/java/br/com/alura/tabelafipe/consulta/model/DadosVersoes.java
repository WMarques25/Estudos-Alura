package br.com.alura.tabelafipe.consulta.model;

public record DadosVersoes(
    String codigo,
    String nome
) {

    @Override
    public String toString() {
        return "Código: " + codigo + " - " + nome + "\n";
    }
}
