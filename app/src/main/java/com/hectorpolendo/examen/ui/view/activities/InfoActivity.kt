package com.hectorpolendo.examen.ui.view.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.hectorpolendo.examen.R
import com.hectorpolendo.examen.databinding.ActivityInfoBinding
import com.hectorpolendo.examen.domain.models.Movie
import com.hectorpolendo.examen.domain.models.TvSerie
import com.hectorpolendo.examen.ui.viewmodel.InfoViewModel
import com.hectorpolendo.examen.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    private val infoViewModel: InfoViewModel by viewModels()
    private var movieId: Int? = null
    private var image: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loading()
        getInformation()
        infoViewModel.onCreate(movieId!!)
        subscribeObservers()

        binding.fbFavorite.setOnClickListener {
            infoViewModel.changeFavorite(movieId!!, image!!)
        }
    }

    private fun loading(){
        with(binding){
            progressBar.visibility = View.VISIBLE
            tvOverview.visibility = View.INVISIBLE
            tvLanguage.visibility = View.INVISIBLE
            tvScore.visibility = View.INVISIBLE
            tvDate.visibility = View.INVISIBLE
        }
    }

    private fun getInformation() {
        movieId = intent.getIntExtra(Constants.MOVIE_ID, 0)!!
    }

    private fun subscribeObservers() {
        infoViewModel.movie.observe(this, object : Observer<Movie> {
            override fun onChanged(t: Movie?) {
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

                onResponseCase()
            }
        })

        infoViewModel.tvSerie.observe(this, object : Observer<TvSerie> {
            override fun onChanged(t: TvSerie?) {
                Glide.with(this@InfoActivity)
                    .load(Constants.PATH_IMGS+t!!.poster_path)
                    .into(binding.ivMovie)

                image = Constants.PATH_IMGS+t!!.poster_path

                binding.collapsingToolbar.title = t!!.name
                binding.collapsingToolbar.setExpandedTitleColor(Color.WHITE)
                binding.collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE)
                binding.tvDate.text = t!!.first_air_date
                binding.tvScore.text = t!!.vote_average.toString()
                binding.tvLanguage.text = t.original_language!!.uppercase()
                binding.tvOverview.text = t!!.overview

                onResponseCase()
            }
        })

        infoViewModel.isFavorite.observe(this, {
            if(it){
                binding.fbFavorite.setImageResource(R.drawable.ic_is_favorite)
            }else{
                binding.fbFavorite.setImageResource(R.drawable.ic_favorite)
            }
        })

    }

    private fun onResponseCase(){
        with(binding){
            progressBar.visibility = View.INVISIBLE
            tvScore.visibility = View.VISIBLE
            tvDate.visibility = View.VISIBLE
            tvLanguage.visibility = View.VISIBLE
            tvOverview.visibility = View.VISIBLE
        }
    }
}