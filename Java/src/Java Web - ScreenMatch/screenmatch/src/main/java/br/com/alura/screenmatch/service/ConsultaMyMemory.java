package br.com.alura.screenmatch.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.screenmatch.service.traducao.DadosTraducao;

public class ConsultaMyMemory {
    private static String texto;
    private static String langpair;

    public static String obterTraducao(String text) {
        ObjectMapper mapper = new ObjectMapper();

        ConsumoAPI consumo = new ConsumoAPI();

        try {
            texto = URLEncoder.encode(text, StandardCharsets.UTF_8.toString());
            //langpair = URLEncoder.encode("en-us|pt-br", StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Erro ao traduzir texto", e);
        }

        String url = "https://api.mymemory.translated.net/get?q=" + texto + "&langpair=" + "en-us%7Cpt-br";

        String json = consumo.obterDados(url);

        DadosTraducao traducao;
        try {
            traducao = mapper.readValue(json, DadosTraducao.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao traduzir texto", e);
        }

        return traducao.dadosResposta().textoTraduzido();
    }
}
