package br.com.alura.alugames.modelo

import br.com.alura.alugames.utilitario.formatoComDuasCasasDecimais

class PlanoAvulso(tipo: String, id: Int = 0): Plano(tipo, id){

    override fun obterValor(aluguel: Aluguel): Double {
        val valorOriginal = super.obterValor(aluguel)
        if (aluguel.gamer.media > 8.0){
            return valorOriginal * 0.9
        } else {
            return valorOriginal.formatoComDuasCasasDecimais()
        }
    }

}
