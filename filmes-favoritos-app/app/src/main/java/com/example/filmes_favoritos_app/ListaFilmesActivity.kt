package com.example.filmes_favoritos_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaFilmesActivity : AppCompatActivity() {

    private val filmeDao = FilmeDaoImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filmes)

        // Corrigido: findViewById com <> e () juntos
        val recyclerViewFilmes = findViewById<RecyclerView>(R.id.recyclerView_filmes)

        val filmes = filmeDao.obterFilmes()

        recyclerViewFilmes.layoutManager = LinearLayoutManager(this)
        recyclerViewFilmes.adapter = FilmeAdapter(filmes)
    }
}

