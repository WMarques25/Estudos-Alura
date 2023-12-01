package br.com.alura.alugames.utilitario

import br.com.alura.alugames.modelo.Jogo

fun Jogo.criaJogo(): Jogo {
    return Jogo(
        this.titulo,
        this.capa,
        this.descricao,
        this.preco
    )
}