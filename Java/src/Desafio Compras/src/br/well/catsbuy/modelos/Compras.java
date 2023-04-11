package br.well.catsbuy.modelos;

public class Compras implements Comparable<Compras>{
    private String descricao;
    private double valor;

    public Compras(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return this.descricao + " - R$" + this.valor + "\n";
    }

    @Override
    public int compareTo(Compras outra) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(outra.getValor()));
    }

}
