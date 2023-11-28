package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.servicos.ConsumoApi
import java.time.LocalDate

fun main(){
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogoJson()

//    println(listaGamers)
//    println(listaJogos)

    val gamerCaroline = listaGamers.get(3);
    val jogoREV = listaJogos.get(10);
    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7));
    val jogoSpider = listaJogos.get(13);
    val jogoTLOU = listaJogos.get(2);
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3));
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10));

//    println("Gamer: ${gamerCaroline.nome} - Jogo: ${jogoREV.titulo}");
    gamerCaroline.alugaJogo(jogoREV, periodo1)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTLOU, periodo3)
    println(gamerCaroline.jogosAlugados)
    println("\n")
    println(gamerCaroline.jogosDoMes(11))
}




