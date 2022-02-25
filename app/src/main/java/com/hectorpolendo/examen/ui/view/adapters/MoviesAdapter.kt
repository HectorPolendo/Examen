package com.hectorpolendo.examen.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hectorpolendo.examen.databinding.ListItemBinding
import com.hectorpolendo.examen.domain.models.Movie
import com.hectorpolendo.examen.util.Constants

class MoviesAdapter(): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    private var moviesList = ArrayList<Movie>()
    lateinit var onItemClick: ((Movie)->Unit)

    fun setMovies(moviesList: ArrayList<Movie>){
        this.moviesList = moviesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(Constants.PATH_IMGS+moviesList[position].poster_path)
            .into(holder.binding.ivImage)

        holder.itemView.setOnClickListener{
            onItemClick.invoke(moviesList[position])
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class ViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)
}