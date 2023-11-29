package br.com.alura.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {

    private String nomeProduto;
    private Integer quantidadeVendida;
    private LocalDate dataUltimaVenda;
    
    public String getNomeProduto() {
        return nomeProduto;
    }
    
    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public LocalDate getDataUltimaVenda() {
        return dataUltimaVenda;
    }

    public RelatorioDeVendasVo(String nomeProduto, Integer quantidadeVendida, LocalDate dataUltimaVenda) {
        this.nomeProduto = nomeProduto;
        this.quantidadeVendida = quantidadeVendida;
        this.dataUltimaVenda = dataUltimaVenda;
    }

    @Override
    public String toString() {
        return "| " + nomeProduto + " | " + quantidadeVendida
                + " | " + dataUltimaVenda + " |";
    }
    

}
