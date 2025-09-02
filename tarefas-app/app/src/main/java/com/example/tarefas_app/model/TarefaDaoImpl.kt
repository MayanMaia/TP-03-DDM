package com.example.tarefas_app.model

class TarefaDaoImpl : TarefaDao {
    companion object {
        private val tarefas = mutableListOf<Tarefa>()
    }

    override fun adicionarTarefa(tarefa: Tarefa) {
        val novaTarefa = tarefa.copy(id = tarefas.size + 1L)
        tarefas.add(novaTarefa)
    }
    override fun obterTarefas(): List<Tarefa> {
        return tarefas
    }
    override fun atualizarTarefa(tarefa: Tarefa) {
        val index = tarefas.indexOfFirst { it.id == tarefa.id }
        if (index != -1) {
            tarefas[index] = tarefa
        }
    }
}