package com.dicoding.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val filmList: List<Film>, private val listener: (Film) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.FilmViewHolder>() {

    inner class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val filmTitle: TextView = view.findViewById(R.id.filmTitle)
        private val filmOverview: TextView = view.findViewById(R.id.filmOverview)
        private val filmImage: ImageView = view.findViewById(R.id.filmImage)

        fun bind(film: Film) {
            filmTitle.text = film.title
            filmOverview.text = film.overview
            filmOverview.maxLines = 2
            filmImage.setImageResource(film.imageResId)
            itemView.setOnClickListener { listener(film) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.canvas_page, parent, false)
        return FilmViewHolder(view)
    }


    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(filmList[position])
    }

    override fun getItemCount(): Int = filmList.size
}
