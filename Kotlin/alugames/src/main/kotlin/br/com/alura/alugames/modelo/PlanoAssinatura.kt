package br.com.alura.alugames.modelo

import br.com.alura.alugames.utilitario.formatoComDuasCasasDecimais

class PlanoAssinatura(tipo: String, val mensalidade: Double,
                      val jogosIncluidos: Int,
                      val percentualDescontoReputacao: Double,
                      id: Int = 0): Plano(tipo, id) {



    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1

        return if(totalJogosNoMes <= jogosIncluidos){
            0.0
        } else {
            var valorOriginal = super.obterValor(aluguel)
            if(aluguel.gamer.media > 8.0){
                valorOriginal -= percentualDescontoReputacao
            }
            return valorOriginal.formatoComDuasCasasDecimais()
        }
    }
}
