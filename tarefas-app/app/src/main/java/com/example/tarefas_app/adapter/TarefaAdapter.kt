package com.example.tarefas_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tarefas_app.R
import com.example.tarefas_app.model.Tarefa



class TarefaAdapter(
    private val tarefas: List<Tarefa>,
    private val onTarefaChecked: (Tarefa, Boolean) -> Unit
) : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvNome: TextView = itemView.findViewById(R.id.txv_nome)
        val txvDescricao: TextView = itemView.findViewById(R.id.txv_descricao)
        val cbConcluida: CheckBox = itemView.findViewById(R.id.cbConcluida)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarefa, parent, false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.txvNome.text = tarefa.nome
        holder.txvDescricao.text = tarefa.descricao

        // Define o estado do CheckBox
        holder.cbConcluida.isChecked = tarefa.concluida

        // Define o listener para o CheckBox.
        holder.cbConcluida.setOnCheckedChangeListener { _, isChecked ->
            onTarefaChecked(tarefa, isChecked)
        }
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }
}