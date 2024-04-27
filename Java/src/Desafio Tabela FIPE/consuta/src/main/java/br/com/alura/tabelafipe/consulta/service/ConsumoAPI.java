package br.com.alura.tabelafipe.consulta.service;

public class ConsumoAPI {
    private final String URL = "https://parallelum.com.br/fipe/api/v1/";
    private final HttpConfig httpConfig = new HttpConfig();
    private String tipoVeiculo;
    private String marcaVeiculo;
    
    public String obterMarcas(Integer i){
        tipoVeiculo  = obterTipo(i) + "/marcas/";

        return httpConfig.buscar(URL + tipoVeiculo);
        
    }

    public String obterTipo(Integer i){
        switch(i){
            case 1:
            return "motos";

            case 2:
            return "carros";

            case 3:
            return "caminhoes";

            default:
            return null;
        }
    }

    public String obterModelos(Integer i) {
        marcaVeiculo = i + "/modelos/";
        return httpConfig.buscar(URL + tipoVeiculo + marcaVeiculo);

    }
}
