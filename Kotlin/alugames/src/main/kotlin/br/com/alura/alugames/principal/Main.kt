package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluido.\n$gamer")

    do {
        print("Digite o codigo do jogo: ")
        val busca = leitura.nextLine()

        val meuInfoJogo = ConsumoApi().buscaJogo(busca)

        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
        }
        resultado.onFailure {
            println("Jogo não encontrado, tente outro código.")
        }
        resultado.onSuccess {
            println("Deseja imserir uma descrição? (S/N)")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Digite a descrição: ")
                meuJogo?.descricao = leitura.nextLine()
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
            gamer.jogosBuscados.add(meuJogo)
        }
        println("Deseja buscar outro jogo? S/N")
        val resposta = leitura.nextLine()

    }while (resposta.equals("s", true))
    println("Jogos buscados:")
    println(gamer.jogosBuscados)

    println("\nJogos Ordenados:")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }
    println("Busca realizada com sucesso!")
}
