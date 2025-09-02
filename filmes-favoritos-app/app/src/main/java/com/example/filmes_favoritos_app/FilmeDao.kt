package com.example.filmes_favoritos_app

interface FilmeDao {
    fun adicionarFilme(filme: Filme)
    fun obterFilmes(): List<Filme>
}