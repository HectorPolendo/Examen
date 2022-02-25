package com.hectorpolendo.examen.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hectorpolendo.examen.R
import com.hectorpolendo.examen.databinding.FragmentHomeBinding
import com.hectorpolendo.examen.util.IOnBackPressed
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(), IOnBackPressed {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val moviesFragment: Fragment = MoviesFragment()
        val fragTransaction = activity!!.supportFragmentManager!!.beginTransaction().add(R.id.container, moviesFragment)
        fragTransaction.commit()

        return binding.root
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}