package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogoJson()

//    println(listaGamers)
//    println(listaJogos)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogos.get(10)
    val jogoSpider = listaJogos.get(13)
    val jogoTheLastOfUs = listaJogos.get(2)
    val jogoDandara = listaJogos.get(5)
    val jogoAssassins = listaJogos.get(4)
    val jogoCyber = listaJogos.get(6)
    val jogoGod = listaJogos.get(7)
    val jogoSkyrim = listaJogos.get(18)
    val jogoREV = listaJogos.get(10);
    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7));
    val jogoTLOU = listaJogos.get(2);
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3));
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10));

//    println("Gamer: ${gamerCaroline.nome} - Jogo: ${jogoREV.titulo}");
    gamerCaroline.alugaJogo(jogoREV, periodo1)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTLOU, periodo3)
//    println(gamerCaroline.jogosAlugados)
//    println("\n")
//    println(gamerCaroline.jogosDoMes(11))

    val gamerCamila = listaGamers.get(5);
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)
    gamerCamila.alugaJogo(jogoREV, periodo1)
    gamerCamila.alugaJogo(jogoSpider, periodo2)
    gamerCamila.alugaJogo(jogoTLOU, periodo3)
    gamerCamila.alugaJogo(jogoTLOU, periodo3)
//    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    println(gamerCamila)

    gamerCamila.alugaJogo(jogoREV, periodo1)
//    println(gamerCamila.jogosAlugados)

    jogoREV.recomendar(10)
    jogoREV.recomendar(9)
    jogoREV.recomendar(5)

//    println("RE: Village - " + jogoREV.media)

//    gamerCamila.recomendarJogo(jogoREV, 7)
//    gamerCamila.recomendarJogo(jogoTLOU, 10)
//
//    gamerCaroline.recomendarJogo(jogoSpider, 10)
//    gamerCaroline.recomendarJogo(jogoTLOU, 10)
//
//    println("Camila: \n" + gamerCamila.jogosRecomendados)
//    println("Caroline: \n" + gamerCaroline.jogosRecomendados)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)
}


