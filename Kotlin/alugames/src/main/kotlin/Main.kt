import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    print("Digite o codigo do jogo: ")
    val busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()
    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

//    try {
//        val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
//        println(meuJogo)
//    } catch (ex: NullPointerException){
//        println("Jogo não encontrado, tente outro código.")
//    }
    var meuJogo:Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    }
    resultado.onFailure {
        println("Jogo não encontrado, tente outro código.")
    }
    resultado.onSuccess {
        println("Deseja imserir uma descrição? (S/N)")
        val opcao = leitura.nextLine()
        if (opcao.equals("s", true)){
            println("Digite a descrição: ")
            meuJogo?.descricao = leitura.nextLine()
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
    }
}