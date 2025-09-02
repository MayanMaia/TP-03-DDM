package com.example.tarefas_app.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarefas_app.R
import com.example.tarefas_app.model.TarefaDao
import com.example.tarefas_app.model.TarefaDaoImpl
import com.example.tarefas_app.adapter.TarefaAdapter
import com.example.tarefas_app.model.Tarefa

class ListaTarefasActivity : AppCompatActivity(R.layout.activity_lista_tarefas) {
    private val dao: TarefaDao = TarefaDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvTarefas = findViewById<RecyclerView>(R.id.rv_tarefas)
        val tarefas = dao.obterTarefas()
        rvTarefas.layoutManager = LinearLayoutManager(this)


        rvTarefas.adapter = TarefaAdapter(tarefas) { tarefa, isChecked ->
            val tarefaAtualizada = tarefa.copy(concluida = isChecked)
            dao.atualizarTarefa(tarefaAtualizada)
        }
    }
}