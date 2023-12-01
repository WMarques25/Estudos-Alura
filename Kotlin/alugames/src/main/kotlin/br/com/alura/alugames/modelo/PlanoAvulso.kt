package br.com.alura.alugames.modelo

class PlanoAvulso(tipo: String): Plano(tipo){

    override fun obterValor(aluguel: Aluguel): Double {
        val valorOriginal = super.obterValor(aluguel)
        if (aluguel.gamer.media > 8.0){
            return valorOriginal * 0.9
        } else {
            return valorOriginal
        }
    }

}
