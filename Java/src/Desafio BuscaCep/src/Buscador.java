import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class Buscador {
    
    public Endereco buscar(String cep){
        URI endereço = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisição = HttpRequest.newBuilder()
                        .uri(endereço).build();

        HttpResponse<String> resposta = null;
        try {
            resposta = cliente.send(requisição, HttpResponse.BodyHandlers
                            .ofString());

            return new Gson().fromJson(resposta.body(), Endereco.class);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o CEP: " + e.getMessage());

        } 
                
    }
}
