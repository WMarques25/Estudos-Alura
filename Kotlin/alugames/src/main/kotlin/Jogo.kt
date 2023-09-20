data class Jogo(val titulo: String, var capa: String) {

    val descricao = ""

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Titulo: '$titulo' \nCapa: '$capa'\nDescricao: '$descricao'"
    }
}