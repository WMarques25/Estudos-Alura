@file:Suppress("SpellCheckingInspection")

package br.com.alura.alugames.modelo

import br.com.alura.alugames.utilitario.formatoComDuasCasasDecimais
import com.google.gson.annotations.Expose

data class Jogo(@Expose val titulo: String, @Expose var capa: String): Recomendavel {

    constructor(titulo: String, capa: String, descricao: String?, preco: Double) : this(titulo, capa) {
        this.descricao = descricao
        this.preco = preco.formatoComDuasCasasDecimais()
    }

    var id: Int = 0
    private val listaNotas: MutableList<Int> = mutableListOf()
    var descricao:String? = null
    var preco:Double = 0.0.formatoComDuasCasasDecimais()

    override fun toString(): String {
        @Suppress("SpellCheckingInspection")
        return "\n\n" +
                "Titulo: '$titulo' \nCapa: '$capa'\nDescricao: '$descricao'\nPreco: '$preco'"
    }

    override val media: Double
        get() = listaNotas.average().formatoComDuasCasasDecimais()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }
}


