package br.well.catsbuy.modelos;

import java.util.ArrayList;
import java.util.List;

public class Cartao {
    private List<Compras> compras;
    private double limite;
    private double saldo;
    
    public Cartao(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<Compras>();
    
    }

    public List<Compras> getCompras() {
        return compras;
    }
    public double getLimite() {
        return limite;
    }
    public double getSaldo() {
        return saldo;
    }

    public boolean comprar(Compras compra) {
        if (compra.getValor() <= this.saldo) {
            this.compras.add(compra);
            this.saldo -= compra.getValor();
            return true;
        }
        return false;
    }

    public String printCompras() {
        String compras = "";
        for (Compras item : this.compras) {
            compras += item.toString() + "\n";
        }
        return compras;
    }
}
