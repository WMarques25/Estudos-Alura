package br.well.loja.http;

import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class JavaHttpClient implements HttpAdapter {

    @Override
    public void post(String url, Map<String, Object> dados) {
        try {
            URL urlDaApi = new URL(url);
            URLConnection openConnection = urlDaApi.openConnection();
            openConnection.connect();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar URL", e);
        }
    }
    
}
