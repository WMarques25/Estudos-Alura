package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi

fun main(){
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogoJson()

//    println(listaGamers)
//    println(listaJogos)

    val gamer1 = listaGamers.get(3)
    val jogo1 = listaJogos.get(10)

}