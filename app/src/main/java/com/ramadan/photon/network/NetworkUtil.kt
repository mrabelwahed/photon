package com.ramadan.photon.network

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity

class NetworkUtil {

    companion object {
        @SuppressLint("ServiceCast")
        fun isNetworkAvailable(activity: AppCompatActivity): Boolean {
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }

}