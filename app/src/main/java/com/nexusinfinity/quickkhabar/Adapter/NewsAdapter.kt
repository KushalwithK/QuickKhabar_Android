package com.nexusinfinity.quickkhabar.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nexusinfinity.quickkhabar.R

class NewsAdapter(var news: ArrayList<String>, private val listener: OnItemClicked) : RecyclerView.Adapter<NewsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_view, parent, false);
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener {
            listener.onClicked(news[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = news[position]
        holder.titleView.text = currentItem
    }

    override fun getItemCount(): Int {
        return news.size
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titleView : TextView = itemView.findViewById(R.id.titleView)
}

interface OnItemClicked{
    fun onClicked(text: String);
}