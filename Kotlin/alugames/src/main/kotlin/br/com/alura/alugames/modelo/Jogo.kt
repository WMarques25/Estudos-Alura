@file:Suppress("SpellCheckingInspection")

package br.com.alura.alugames.modelo

data class Jogo(val titulo: String, var capa: String) {

    constructor(titulo: String, capa: String, descricao: String?, preco: Double) : this(titulo, capa) {
        this.descricao = descricao
        this.preco = preco
    }

    var descricao:String? = null
    var preco:Double = 0.0

    override fun toString(): String {
        @Suppress("SpellCheckingInspection")
        return "\n\n" +
                "Titulo: '$titulo' \nCapa: '$capa'\nDescricao: '$descricao'\nPreco: '$preco'"
    }
}


