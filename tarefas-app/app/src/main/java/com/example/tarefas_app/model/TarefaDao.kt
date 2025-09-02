package com.example.tarefas_app.model

interface TarefaDao {
    fun adicionarTarefa(tarefa: Tarefa)
    fun obterTarefas(): List<Tarefa>
    fun atualizarTarefa(tarefa: Tarefa)
}