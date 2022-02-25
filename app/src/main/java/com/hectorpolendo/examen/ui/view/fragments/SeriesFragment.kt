package com.hectorpolendo.examen.ui.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hectorpolendo.examen.databinding.FragmentSeriesBinding
import com.hectorpolendo.examen.domain.models.TvSerie
import com.hectorpolendo.examen.ui.view.activities.InfoActivity
import com.hectorpolendo.examen.ui.view.adapters.SeriesAdapter
import com.hectorpolendo.examen.ui.viewmodel.SeriesViewModel
import com.hectorpolendo.examen.util.Constants
import com.hectorpolendo.examen.util.SelectorFragmentDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment : Fragment() {
    private lateinit var binding: FragmentSeriesBinding
    private val seriesViewModel: SeriesViewModel by viewModels()

    private lateinit var popularSeriesAdapter: SeriesAdapter
    private lateinit var seriesTopRatedAdapter: SeriesAdapter
    private lateinit var seriesAiringTodayAdapter: SeriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        seriesViewModel.onCreate()
        initAdapters()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSeriesBinding.inflate(layoutInflater, container, false)

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

        binding.rvPopularSeries.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = popularSeriesAdapter
        }

        binding.rvTopRatedSeries.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = seriesTopRatedAdapter
        }

        binding.rvAiringToday.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = seriesAiringTodayAdapter
        }
        itemsClicks()

        subscribeObservers()
    }

    fun subscribeObservers(){
        seriesViewModel.popular.observe(this, {
            popularSeriesAdapter.setSeries(it as ArrayList<TvSerie>)
        })

        seriesViewModel.topRated.observe(this, {
            seriesTopRatedAdapter.setSeries(it as ArrayList<TvSerie>)
        })

        seriesViewModel.airingToday.observe(this, {
            seriesAiringTodayAdapter.setSeries(it as ArrayList<TvSerie>)
        })
    }

    fun initAdapters(){
        popularSeriesAdapter = SeriesAdapter()
        seriesTopRatedAdapter = SeriesAdapter()
        seriesAiringTodayAdapter = SeriesAdapter()
    }

    fun itemsClicks(){
        popularSeriesAdapter.onItemClick = {
            Constants.FROM = "POPULAR_SERIE"
            startActivity(
                Intent(activity, InfoActivity::class.java)
                    .putExtra(Constants.MOVIE_ID, it.id))
        }

        seriesTopRatedAdapter.onItemClick = {
            Constants.FROM = "TOP_RATED_SERIE"
            startActivity(
                Intent(activity, InfoActivity::class.java)
                    .putExtra(Constants.MOVIE_ID, it.id))
        }

        seriesAiringTodayAdapter.onItemClick = {
            Constants.FROM = "AIRING_TODAY"
            startActivity(
                Intent(activity, InfoActivity::class.java)
                    .putExtra(Constants.MOVIE_ID, it.id))
        }
    }
}