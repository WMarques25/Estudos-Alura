package br.well.screenmatch.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;                
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.well.screenmatch.exception.AnoMaiorQueQuatroDigitosException;
import br.well.screenmatch.modelos.TituloOmdb;
import br.well.screenmatch.modelos.Titulos;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String nome = " ";
        List<Titulos> titulos = new ArrayList<>();
        
        Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setPrettyPrinting()
        .create();

        while(!nome.equalsIgnoreCase("sair")){
            System.out.println("Digite o nome do filme: ");
            nome = sc.nextLine();

            if(nome.equalsIgnoreCase("sair")){
                System.out.println("Saindo...");
                break;
            }

            try {
                String endereço = "https://www.omdbapi.com/?t=" + nome.replace(" ", "+") + "&apikey=585c8098";

                // TODO - Criar uma classe para fazer a requisição
                HttpClient cliente = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereço)).build();
                HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json + "\n\tjson \n");

                TituloOmdb t1Omdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(t1Omdb + "\n\tt1Omdb \n");

                // try{
                Titulos t1 = new Titulos(t1Omdb);
                System.out.println(t1 + "\n\tt1 \n");
                
                titulos.add(t1);

            } catch (NumberFormatException e) {
                System.out.println("\n\tErro: " + e.getMessage() + "\n");

            } catch (IllegalArgumentException e) {
                System.out.println("\n\tErro: " + e.getMessage() + "\n");

            } catch (AnoMaiorQueQuatroDigitosException e) {
                System.out.println("\n\tErro: " + e.getMessage() + "\n");

            }
        }
        System.out.println(titulos);

        FileWriter fw = new FileWriter("titulos.json");
        fw.write(gson.toJson(titulos));
        fw.close();
        sc.close();
    }
}