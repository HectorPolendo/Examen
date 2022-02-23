package com.hectorpolendo.examen.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hectorpolendo.examen.R
import com.hectorpolendo.examen.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}