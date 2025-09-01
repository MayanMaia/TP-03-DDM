package com.example.filmes_favoritos_app

object FilmeDaoImpl : FilmeDao {
    private val filmes: MutableList<Filme> = mutableListOf()
    override fun adicionarFilme(filme: Filme) {
        filmes.add(filme)
    }
    override fun obterFilmes(): List<Filme> {
        return filmes
    }
}
