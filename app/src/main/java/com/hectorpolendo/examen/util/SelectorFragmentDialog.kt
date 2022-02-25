package com.hectorpolendo.examen.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.hectorpolendo.examen.R
import com.hectorpolendo.examen.databinding.SelectorDialogBinding
import com.hectorpolendo.examen.ui.view.fragments.MoviesFragment
import com.hectorpolendo.examen.ui.view.fragments.SeriesFragment

class SelectorFragmentDialog: DialogFragment() {
    private lateinit var binding: SelectorDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SelectorDialogBinding.inflate(inflater, container, false)

        binding.tvMovies.setOnClickListener {
            val fragmentManager = activity!!.supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)

            val moviesFragment: Fragment = MoviesFragment()
            transaction.replace(R.id.container, moviesFragment)

            transaction.addToBackStack(null)
            transaction.commit()

            dismiss()
        }

        binding.tvSeries.setOnClickListener {
            val fragmentManager = activity!!.supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)

            val seriesFragment: Fragment = SeriesFragment()
            transaction.replace(R.id.container, seriesFragment)

            transaction.addToBackStack(null)
            transaction.commit()

            dismiss()
        }

        return binding.root
    }
}