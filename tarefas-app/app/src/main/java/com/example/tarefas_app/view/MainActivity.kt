package com.example.tarefas_app.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tarefas_app.R
import com.example.tarefas_app.model.Tarefa
import com.example.tarefas_app.model.TarefaDaoImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val dao = TarefaDaoImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtNome = findViewById<EditText>(R.id.edt_nome_tarefa)
        val edtDescricao = findViewById<EditText>(R.id.edt_descricao_tarefa)
        val btnAdicionar = findViewById<Button>(R.id.btn_adicionar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)

        btnAdicionar.setOnClickListener {
            val nome = edtNome.text.toString()
            val descricao = edtDescricao.text.toString()
            val tarefa = Tarefa(nome = nome, descricao = descricao)
            dao.adicionarTarefa(tarefa)
            edtNome.text.clear()
            edtDescricao.text.clear()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Tarefa Adicionada!")
            val alert = builder.create()
            alert.show()
        }
        fabAvanca.setOnClickListener {
            val intent = Intent(this, ListaTarefasActivity::class.java)
            startActivity(intent)
        }

    }
}