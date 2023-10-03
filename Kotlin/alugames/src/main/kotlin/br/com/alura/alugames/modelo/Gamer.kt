package br.com.alura.alugames.modelo

data class Gamer(var nome:String, var email:String) {
    val dataNascimento:String? = null
    var usuario:String? = null
    var idInterno:String? = null

    constructor(nome: String, email: String, dataNascimento: String, usuario: String, idInterno: String) :
            this(nome, email)

    }
}
