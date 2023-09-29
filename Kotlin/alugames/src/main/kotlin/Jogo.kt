data class Jogo(val titulo: String, var capa: String) {

    var descricao:String? = null

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Titulo: '$titulo' \nCapa: '$capa'\nDescricao: '$descricao'"
    }
}


