package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.InfoJogo
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    print("Digite o codigo do jogo: ")
    val busca = leitura.nextLine()

    val meuInfoJogo = ConsumoApi().buscaJogo(busca)

//    try {
//        val meuJogo = br.com.alura.alugames.modelo.Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
//        println(meuJogo)
//    } catch (ex: NullPointerException){
//        println("br.com.alura.alugames.modelo.Jogo não encontrado, tente outro código.")
//    }
    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    }
    resultado.onFailure {
        println("br.com.alura.alugames.modelo.Jogo não encontrado, tente outro código.")
    }
    resultado.onSuccess {
        println("Deseja imserir uma descrição? (S/N)")
        val opcao = leitura.nextLine()
        if (opcao.equals("s", true)){
            println("Digite a descrição: ")
            meuJogo?.descricao = leitura.nextLine()
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca realizada com sucesso!")
    }
}