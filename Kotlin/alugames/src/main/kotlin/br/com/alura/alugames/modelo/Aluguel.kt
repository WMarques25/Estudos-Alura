package br.com.alura.alugames.modelo

import br.com.alura.alugames.utilitario.formatoComDuasCasasDecimais

data class Aluguel(
    val gamer:Gamer,
    val jogo:Jogo,
    val periodo: Periodo) {
    val valorDoAluguel = gamer.plano.obterValor(this).formatoComDuasCasasDecimais()

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.usuario}. R$ ${valorDoAluguel}"
    }


}