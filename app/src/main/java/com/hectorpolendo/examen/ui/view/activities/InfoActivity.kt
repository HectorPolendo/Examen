package com.hectorpolendo.examen.ui.view.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.hectorpolendo.examen.databinding.ActivityInfoBinding
import com.hectorpolendo.examen.domain.models.Video
import com.hectorpolendo.examen.ui.view.adapters.VideosAdapter
import com.hectorpolendo.examen.ui.viewmodel.InfoViewModel
import com.hectorpolendo.examen.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import com.google.android.material.chip.Chip
import android.util.TypedValue
import com.hectorpolendo.examen.R
import com.hectorpolendo.examen.util.Method

@AndroidEntryPoint
class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    private val infoViewModel: InfoViewModel by viewModels()
    private lateinit var videosAdapter: VideosAdapter
    private var movieId: Int? = null
    private var image: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videosAdapter = VideosAdapter()
        loading()
        getInformation()
        infoViewModel.onCreate(movieId!!)
        subscribeObservers()

        binding.fbFavorite.setOnClickListener {
            infoViewModel.changeFavorite(movieId!!, image!!)
        }

        binding.rvTrailers.apply {
            layoutManager = LinearLayoutManager(this@InfoActivity, LinearLayoutManager.VERTICAL, false)
            adapter = videosAdapter
        }

        if(!Method.isOnline(this@InfoActivity)){
            binding.tvTrailers.visibility = View.GONE
        }
    }

    private fun getInformation() {
        movieId = intent.getIntExtra(Constants.MOVIE_ID, 0)!!
    }

    private fun subscribeObservers() {
        infoViewModel.movie.observe(this,
            { t ->
                Glide.with(this@InfoActivity)
                    .load(Constants.PATH_IMGS+t!!.poster_path)
                    .into(binding.ivMovie)

                image = Constants.PATH_IMGS+t!!.poster_path

                binding.collapsingToolbar.title = t!!.title
                binding.collapsingToolbar.setExpandedTitleColor(Color.WHITE)
                binding.collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE)
                binding.tvDate.text = t!!.release_date
                if(t.vote_average!! > 0){
                    binding.tvScore.text = t!!.vote_average.toString()
                }else{
                    binding.tvScore.text = "Sin calificación"
                }

                binding.tvLanguage.text = t.original_language!!.uppercase()
                binding.tvOverview.text = t!!.overview

                infoViewModel.getGenre(true)
                infoViewModel.getVideos(this@InfoActivity, t.id!!, true)
            })

        infoViewModel.tvSerie.observe(this,
            { t ->
                Glide.with(this@InfoActivity)
                    .load(Constants.PATH_IMGS+t!!.poster_path)
                    .into(binding.ivMovie)

                image = Constants.PATH_IMGS+t!!.poster_path

                binding.collapsingToolbar.title = t!!.name
                binding.collapsingToolbar.setExpandedTitleColor(Color.WHITE)
                binding.collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE)
                binding.tvDate.text = t!!.first_air_date
                if(t.vote_average!! > 0){
                    binding.tvScore.text = t!!.vote_average.toString()
                }else{
                    binding.tvScore.text = "Sin calificación"
                }
                binding.tvLanguage.text = t.original_language!!.uppercase()
                binding.tvOverview.text = t!!.overview

                infoViewModel.getGenre(false)
                infoViewModel.getVideos(this@InfoActivity, t.id!!, false)
            })

        infoViewModel.isFavorite.observe(this, {
            if(it){
                binding.fbFavorite.setImageResource(R.drawable.ic_is_favorite)
            }else{
                binding.fbFavorite.setImageResource(R.drawable.ic_favorite)
            }
            onResponseCase()
        })

        infoViewModel.videos.observe(this, {
            videosAdapter.setVideos(it as ArrayList<Video>)
        })

        infoViewModel.genres.observe(this, {
            it.forEach {
                val mChip =
                    this.layoutInflater.inflate(R.layout.item_chip_genre, null, false) as Chip
                mChip.text = it.name
                val paddingDp = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 10f,
                    resources.displayMetrics
                ).toInt()
                mChip.setPadding(paddingDp, 0, paddingDp, 0)
                mChip.setOnCheckedChangeListener { compoundButton, b -> }
                binding.cpGroup.addView(mChip)
            }
        })
    }

    private fun loading(){
        with(binding){
            progressBar.visibility = View.VISIBLE
            tvOverview.visibility = View.INVISIBLE
            tvLanguage.visibility = View.INVISIBLE
            tvScore.visibility = View.INVISIBLE
            tvDate.visibility = View.INVISIBLE
            cpGroup.visibility = View.INVISIBLE
            rvTrailers.visibility = View.INVISIBLE
        }
    }

    private fun onResponseCase(){
        with(binding){
            progressBar.visibility = View.INVISIBLE
            tvOverview.visibility = View.VISIBLE
            tvLanguage.visibility = View.VISIBLE
            tvScore.visibility = View.VISIBLE
            tvDate.visibility = View.VISIBLE
            cpGroup.visibility = View.VISIBLE
            rvTrailers.visibility = View.VISIBLE
        }
    }
}