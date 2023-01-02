package com.example.newsappretrofit

import MODELS_CLASS.Articles
import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class MyAdapter(val context: Context,val  articles: List<Articles>) :
    RecyclerView.Adapter<MyAdapter.ArticleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.news_layout,parent,false)
        return ArticleViewHolder(view)

    }


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article=articles[position]
        holder.title.text=article.title
        holder.description.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.image)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.newsImage)
        var title = itemView.findViewById<TextView>(R.id.newsTitle)
        var description = itemView.findViewById<TextView>(R.id.newsDescription)
    }


}