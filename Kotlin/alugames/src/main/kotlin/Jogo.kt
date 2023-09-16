class Jogo(val titulo: String) {
    var capa = ""
    val descricao = ""

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Titulo: '$titulo' \nCapa: '$capa'\nDescricao: '$descricao'"
    }
}


