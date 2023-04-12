package br.well.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.well.screenmatch.modelos.TituloOmdb;
import br.well.screenmatch.modelos.Titulos;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do filme: ");
        var nome = sc.nextLine();

        String endereço = "https://www.omdbapi.com/?t=" + nome +"&apikey=585c8098";

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereço)).build();
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        
        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .create();
        
        TituloOmdb t1Omdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(t1Omdb);
        Titulos t1 = new Titulos(t1Omdb);
        System.out.println(t1);
        
        sc.close();
    }
}
