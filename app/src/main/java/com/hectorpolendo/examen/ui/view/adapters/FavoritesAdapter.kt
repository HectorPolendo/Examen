package com.hectorpolendo.examen.ui.view.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hectorpolendo.examen.R
import com.hectorpolendo.examen.data.database.entities.FavoriteEntity
import com.hectorpolendo.examen.databinding.FavoriteItemBinding
import com.hectorpolendo.examen.databinding.ListItemBinding
import com.hectorpolendo.examen.domain.models.Movie
import com.hectorpolendo.examen.ui.view.activities.InfoActivity
import com.hectorpolendo.examen.util.Constants

class FavoritesAdapter(): RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {

    private var favoriteList = ArrayList<FavoriteEntity>()
    private lateinit var onItemClick: ((FavoriteEntity)->Unit)
    private lateinit var context: Context

    fun setFavorites(favoriteList: ArrayList<FavoriteEntity>, context: Context){
        this.favoriteList = favoriteList
        this.context = context
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FavoriteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fav = favoriteList[position]
        holder.bind(fav)
    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }

    inner class ViewHolder(var binding: FavoriteItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(fav: FavoriteEntity){
            binding.favorite = fav
            binding.executePendingBindings()
            binding.cardview.setOnClickListener {
                Constants.FROM = fav.ref
                context.startActivity(Intent(context, InfoActivity::class.java)
                    .putExtra(Constants.MOVIE_ID, fav.id))
            }
        }
    }
}