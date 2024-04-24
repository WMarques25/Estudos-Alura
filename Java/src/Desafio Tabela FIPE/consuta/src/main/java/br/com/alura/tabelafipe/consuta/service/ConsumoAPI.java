package br.com.alura.tabelafipe.consuta.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    private final String URL = "https://parallelum.com.br/fipe/api/v1";
    private String tipoVeiculo;
    
    public String obterMarcas(Integer i){
        tipoVeiculo  = obterTipo(i) + "/marcas";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL + tipoVeiculo))
                    .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
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
}
