package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.InfoGamerJson
import br.com.alura.alugames.modelo.InfoJogo
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.utilitario.criaGamer
import br.com.alura.alugames.utilitario.criaJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

//https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json
class ConsumoApi {

    fun consomeDados(endereco:String):String{
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }
    fun buscaJogo(id:String):InfoJogo {
    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

    val json = consomeDados(endereco)

    val gson = Gson()
    val meuInfoJogo:InfoJogo = gson.fromJson(json, InfoJogo::class.java)

    return meuInfoJogo
    }

    fun buscaJogoJson():List<Jogo>{
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

        val json = consomeDados(endereco)

        val jogoTipo = object : TypeToken<List<Jogo>>() {}.type
        val gson = Gson()
        val listaJogos : List<Jogo> = gson.fromJson(json, jogoTipo)

        val listaJogosConvertida = listaJogos.map{ Jogo -> Jogo.criaJogo()}
        return listaJogosConvertida
    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consomeDados(endereco)

        val gamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        val gson = Gson()
        val listaGamers : List<InfoGamerJson> = gson.fromJson(json, gamerTipo)

        val listaGamersConvertida = listaGamers.map{ infoGamerJson -> infoGamerJson.criaGamer()}
        return listaGamersConvertida
    }
}