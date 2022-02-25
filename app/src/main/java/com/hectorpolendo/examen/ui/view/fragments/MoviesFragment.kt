package com.hectorpolendo.examen.ui.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hectorpolendo.examen.databinding.FragmentMoviesBinding
import com.hectorpolendo.examen.domain.models.Movie
import com.hectorpolendo.examen.ui.view.activities.InfoActivity
import com.hectorpolendo.examen.ui.view.adapters.MoviesAdapter
import com.hectorpolendo.examen.ui.viewmodel.MoviesViewModel
import com.hectorpolendo.examen.util.Constants
import com.hectorpolendo.examen.util.SelectorFragmentDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding
    private val homeViewModel: MoviesViewModel by viewModels()

    private lateinit var mostPopularAdapter: MoviesAdapter
    private lateinit var playinNowAdapter: MoviesAdapter
    private lateinit var upcomingAdapter: MoviesAdapter
    private lateinit var topRatedAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.onCreate()
        initAdapters()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)

        binding.tvSpinner.setOnClickListener {
            val fragmentManager = activity!!.supportFragmentManager
            val transaction = fragmentManager.beginTransaction()

            transaction.addToBackStack(null)

            var dialog = SelectorFragmentDialog()
            dialog.show(fragmentManager, "customDialog")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMostPopular.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = mostPopularAdapter
        }

        binding.rvPlayingNow.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = playinNowAdapter
        }

        binding.rvUpcoming.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = upcomingAdapter
        }

        binding.rvTopRated.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = topRatedAdapter
        }

        itemsClicks()

        subscribeObservers()
    }

    fun subscribeObservers(){
        homeViewModel.popular.observe(this, {
            mostPopularAdapter.setMovies(it as ArrayList<Movie>)
        })

        homeViewModel.playingNow.observe(this, {
            playinNowAdapter.setMovies(it as ArrayList<Movie>)
        })

        homeViewModel.upcoming.observe(this, {
            upcomingAdapter.setMovies(it as ArrayList<Movie>)
        })

        homeViewModel.topRated.observe(this, {
            topRatedAdapter.setMovies(it as ArrayList<Movie>)
        })
    }

    fun initAdapters(){
        mostPopularAdapter = MoviesAdapter()
        playinNowAdapter = MoviesAdapter()
        upcomingAdapter = MoviesAdapter()
        topRatedAdapter = MoviesAdapter()
    }

    fun itemsClicks(){
        mostPopularAdapter.onItemClick = {
            Constants.FROM = "POPULAR_MOVIE"
            startActivity(
                Intent(activity, InfoActivity::class.java)
                .putExtra(Constants.MOVIE_ID, it.id))
        }

        playinNowAdapter.onItemClick = {
            Constants.FROM = "PLAYING_NOW"
            startActivity(
                Intent(activity, InfoActivity::class.java)
                    .putExtra(Constants.MOVIE_ID, it.id))
        }

        upcomingAdapter.onItemClick = {
            Constants.FROM = "UPCOMING"
            startActivity(
                Intent(activity, InfoActivity::class.java)
                    .putExtra(Constants.MOVIE_ID, it.id))
        }

        topRatedAdapter.onItemClick = {
            Constants.FROM = "TOP_RATED_MOVIES"
            startActivity(
                Intent(activity, InfoActivity::class.java)
                    .putExtra(Constants.MOVIE_ID, it.id))
        }
    }
}