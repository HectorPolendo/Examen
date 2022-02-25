package com.hectorpolendo.examen.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hectorpolendo.examen.databinding.ListItemBinding
import com.hectorpolendo.examen.domain.models.TvSerie
import com.hectorpolendo.examen.util.Constants

class SeriesAdapter(): RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {
    private var seriesList = ArrayList<TvSerie>()
    lateinit var onItemClick: ((TvSerie)->Unit)

    fun setSeries(seriesList: ArrayList<TvSerie>){
        this.seriesList = seriesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(Constants.PATH_IMGS+seriesList[position].poster_path)
            .into(holder.binding.ivImage)

        holder.itemView.setOnClickListener{
            onItemClick.invoke(seriesList[position])
        }
    }

    override fun getItemCount(): Int {
        return seriesList.size
    }

    class ViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)
}