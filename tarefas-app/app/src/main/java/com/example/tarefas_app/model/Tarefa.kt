package com.example.tarefas_app.model

data class Tarefa(
    var id: Long = 0,
    val nome: String = "",
    val descricao: String = "",
    var concluida: Boolean = false
)