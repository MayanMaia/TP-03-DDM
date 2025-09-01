package com.example.filmes_favoritos_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val filmeDao = FilmeDaoImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTitulo = findViewById<EditText>(R.id.editText_titulo)
        val editTextDiretor = findViewById<EditText>(R.id.editText_diretor)
        val buttonAdicionar = findViewById<Button>(R.id.button_adicionar)
        val buttonListarFilmes = findViewById<Button>(R.id.button_listar_filmes)

        buttonAdicionar.setOnClickListener {
            val titulo = editTextTitulo.text.toString()
            val diretor = editTextDiretor.text.toString()
            val filme = Filme(titulo, diretor)
            filmeDao.adicionarFilme(filme)
            editTextTitulo.text.clear()
            editTextDiretor.text.clear()
        }

        buttonListarFilmes.setOnClickListener {
            val intent = Intent(this, ListaFilmesActivity::class.java)
            startActivity(intent)
        }
    }
}