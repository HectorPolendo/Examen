package com.hectorpolendo.examen.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hectorpolendo.examen.databinding.VideoItemBinding
import com.hectorpolendo.examen.domain.models.Video
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class VideosAdapter(): RecyclerView.Adapter<VideosAdapter.ViewHolder>() {
    private var videosList = ArrayList<Video>()
    lateinit var onItemClick: ((Video)->Unit)

    fun setVideos(videosList: ArrayList<Video>){
        this.videosList = videosList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(VideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = videosList[position]
        if(video.type == "Trailer"){
            holder.binding.YTVideo
            holder.binding.YTVideo.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.cueVideo(video.key, 0f)
                }
            })
        }
    }

    override fun getItemCount(): Int {
        return videosList.size
    }

    class ViewHolder(val binding: VideoItemBinding): RecyclerView.ViewHolder(binding.root)
}