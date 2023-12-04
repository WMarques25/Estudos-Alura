package br.com.alura.alugames.modelo

import br.com.alura.alugames.utilitario.formatoComDuasCasasDecimais
import java.util.*
import kotlin.random.Random

data class Gamer(var nome:String, var email:String): Recomendavel {
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
    val jogosAlugados = mutableListOf<Aluguel>()
    var plano:Plano = PlanoAvulso("BRONZE")
    private val listaNotas = mutableListOf<Int>()
    val jogosRecomendados = mutableListOf<Jogo>()
    var id: Int = 0

    override val media: Double
        get() = listaNotas.average().formatoComDuasCasasDecimais()

    fun recomendarJogo(jogo: Jogo, nota: Int){
        jogo.recomendar(nota)
        jogosRecomendados.add(jogo)
    }

    override fun recomendar(nota: Int) {
        if (nota < 1 || nota > 10) {
            println("Nota inválida. Insira uma nota entre 1 e 10")
        } else {
            listaNotas.add(nota)
        }
    }

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
        return "Nome: '$nome',\n"+
            "E-mail: '$email',\n"+
            "Data Nascimento: $dataNascimento,\n"+
            "Usuario: $usuario,\n"+
            "IdInterno: $idInterno\n"+
            "Reputação: $media\n"    }

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

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel{
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)
        return aluguel
    }

    fun jogosDoMes(mes: Int): List<Jogo> {
        return jogosAlugados.filter { 
            aluguel ->  aluguel.periodo.dataInicial.monthValue == mes
            }.map { aluguel -> aluguel.jogo}
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