package com.hectorpolendo.examen.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.hectorpolendo.examen.data.database.entities.FavoriteEntity
import com.hectorpolendo.examen.databinding.FragmentFavoriteBinding
import com.hectorpolendo.examen.ui.view.adapters.FavoritesAdapter
import com.hectorpolendo.examen.ui.viewmodel.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var adapter: FavoritesAdapter
    private val favoritesViewModel: FavoritesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoritesViewModel.onCreate()
        adapter = FavoritesAdapter()
        subscribeObservers()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        return binding.root
    }

    private fun subscribeObservers() {
        favoritesViewModel.favorites.observe(this, {
            adapter.setFavorites(it as ArrayList<FavoriteEntity>, context!!)
            binding.adapter = adapter
            if(it.isEmpty()){
                binding.rvFavorites.visibility = View.GONE
                binding.constContainer.visibility = View.VISIBLE
            }else{
                binding.rvFavorites.visibility = View.VISIBLE
                binding.constContainer.visibility = View.GONE
            }
        })
    }
}