package com.sam.weather.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.sam.weather.MyApplication


object Util {

    private const val ZOOQR = "gogozooMyQR.png"
    private const val GALLERY_IMAGE_REQ_CODE = 102

    fun isInternetConnected(): Boolean {
        val cm = MyApplication.INSTANCE
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

    fun getString(resourceId: Int): String {
        return MyApplication.INSTANCE.getString(resourceId)
    }

}