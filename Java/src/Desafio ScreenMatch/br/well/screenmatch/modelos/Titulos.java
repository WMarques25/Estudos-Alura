package br.well.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

import br.well.screenmatch.exception.AnoMaiorQueQuatroDigitosException;

public class Titulos implements Comparable<Titulos>{
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;
    private int totalDeAvaliacoes;
    private double duracaoEmMinutos;
    private double somaDasAvaliacoes;
    private boolean incluidoNoPlano;
    
    public Titulos(String nome, int anoDeLancamento, boolean incluidoNoPlano) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public Titulos(TituloOmdb t) {
        this.nome = t.title();
        if(t.year().length() > 4){
            throw new AnoMaiorQueQuatroDigitosException("Ano maior que 4 dígitos: " + t.year());
            
        } 
        this.anoDeLancamento = Integer.valueOf(t.year());
        this.duracaoEmMinutos = Double.valueOf(t.runtime().substring(0, 3));
    }

    public void exibeFichaTecnica(){
        System.out.println(String.format("""
            Nome: %s (%d)
            Duração: %.0f min
            Avaliação: %.1f (%d avaliações)
            Incluído no plano: %s
            """, nome, anoDeLancamento, duracaoEmMinutos, pegaMedia(),
             getTotalDeAvaliacoes(), incluidoNoPlano ? "Sim" : "Não"
        ));
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(double duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getTotalDeAvaliacoes(){
        return this.totalDeAvaliacoes;
    }

    public String getNome() {
        return this.nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }

    public double getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;
    }

    public boolean isIncluidoNoPlano() {
        return this.incluidoNoPlano;
    }

    @Override
    public int compareTo(Titulos outro) {
        return this.getNome().compareTo(outro.getNome());
    }

    @Override
    public String toString() {
        return "nome=" + nome + " (" + anoDeLancamento + "), " + duracaoEmMinutos + " min.";
    }

    
}
