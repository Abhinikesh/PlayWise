package com.example.playwise

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest

class NetworkMonitor(private val context: Context) {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private var networkCallback: ConnectivityManager.NetworkCallback? = null

    fun start(onNetworkStatus: (Boolean) -> Unit) {
        networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                onNetworkStatus(true)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                onNetworkStatus(false)
            }
        }
        val networkRequest = NetworkRequest.Builder().build()
        networkCallback?.let { connectivityManager.registerNetworkCallback(networkRequest, it) }
    }

    fun stop() {
        networkCallback?.let { connectivityManager.unregisterNetworkCallback(it) }
    }
}