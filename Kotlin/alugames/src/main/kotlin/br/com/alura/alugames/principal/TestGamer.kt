import br.com.alura.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("wellington", "well@asd.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Let",
        "lele@lele.com",
        "04/07/1999",
        "lua")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "25/08/1997"
        it.usuario = "WellDarg"
    }.also {
        println(gamer1.usuario + " " + gamer1.idInterno)
    }
    println(gamer1)
    gamer1.usuario = "Wanderclewson"
    println(gamer1)
}