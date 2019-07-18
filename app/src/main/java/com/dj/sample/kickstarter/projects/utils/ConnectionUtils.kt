package com.dj.sample.kickstarter.projects.utils

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService
import org.koin.core.context.GlobalContext.get

/**
 * Connection utils class to provide connection related utility.
 */

class ConnectionUtils(val appContext : Context) {

    fun isConnectedToNetwork(): Boolean {
        val cm = appContext.getSystemService("connectivity") as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }

}