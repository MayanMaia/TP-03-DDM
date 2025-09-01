package com.example.filmes_favoritos_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class FilmeAdapter(private val filmes: List<Filme>) :
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitulo: TextView =
            itemView.findViewById(R.id.textView_tituloFilme)
        val textViewDiretor: TextView =
            itemView.findViewById(R.id.textView_diretorFilme)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.textViewTitulo.text = filme.titulo
        holder.textViewDiretor.text = filme.diretor
    }
    override fun getItemCount(): Int {
        return filmes.size
    }
}
