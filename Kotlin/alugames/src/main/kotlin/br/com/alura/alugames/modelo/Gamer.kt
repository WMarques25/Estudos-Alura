package br.com.alura.alugames.modelo

import java.util.Scanner
import kotlin.random.Random
import br.com.alura.alugames.modelo.Jogo

data class Gamer(var nome:String, var email:String) {
    var dataNascimento:String? = null
    var usuario:String? = null
        set(value) {
            field = value
            if(idInterno.isNullOrBlank()){
                criarIdInterno()
            }
        }
    var idInterno:String? = null
        private set
    val jogosBuscados = mutableListOf<Jogo?>()
    constructor(nome: String, email: String, dataNascimento: String, usuario: String):
            this(nome, email){
        this.usuario = usuario
        this.dataNascimento = dataNascimento
        criarIdInterno()
    }

    init {
        if(nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome Invalido")
        }
        this.email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)){
            return email
        } else{
            throw IllegalArgumentException("Email invalido")
        }
    }

    fun alugaJogo(jogo: Jogo): Aluguel{
        return Aluguel(this, jogo)
    }

    companion object{
        fun criarGamer(leitura: Scanner): Gamer{
            print("""Bem vindo ao AluGames!
                |Vamos fazer seu cadastro.
                |
                |Digite seu nome: 
            """.trimMargin())
            val nome = leitura.nextLine()
            print("Digite seu e-mail: ")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if(opcao.equals("s", true)){
                print("Digite sua data de nascimento(DD/MM/AAAA): ")
                val nascimento = leitura.nextLine()
                print("Digite seu nome de usuário: ")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else {
                return Gamer(nome, email)
            }
        }
    }
}