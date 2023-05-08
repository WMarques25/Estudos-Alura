package br.well.screenmatch.principal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpCliente {
    String body;
    HttpResponse<String> response;

    public HttpCliente(String endereço) throws Exception{

        try{
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereço)).build();
            this.response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            this.body = response.body();

        } catch (IllegalArgumentException e) {
            System.out.println("\n\tErro: " + e.getMessage() + "\n");

        } catch (Exception e) {
            System.out.println("\n\tErro: " + e.getMessage() + "\n");

        }
    }

    public String getBody() {
        return body;
    }
}