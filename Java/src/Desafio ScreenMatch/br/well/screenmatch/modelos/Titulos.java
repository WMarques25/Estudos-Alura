package br.well.screenmatch.modelos;

public class Titulos implements Comparable<Titulos>{
    private String nome;
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
}
