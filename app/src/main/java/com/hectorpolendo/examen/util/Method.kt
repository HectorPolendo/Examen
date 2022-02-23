package com.hectorpolendo.examen.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.hectorpolendo.examen.data.database.entities.MostPopularEntity
import com.hectorpolendo.examen.domain.models.Movie

object Method {

    fun isOnline(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.getActiveNetworkInfo()
        if (activeNetwork != null) {
           return true
        }
        return false
    }
}