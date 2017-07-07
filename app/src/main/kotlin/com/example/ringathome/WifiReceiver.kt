package com.example.ringathome

import android.content.Intent
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.content.BroadcastReceiver
import android.content.Context

class WifiReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        println("onReceive")
        if (context == null || intent == null) return
        if (intent.action == WifiManager.NETWORK_STATE_CHANGED_ACTION) {
            val extras = intent.extras
            println(extras)
            val nw = extras.getParcelable<NetworkInfo>(WifiManager.EXTRA_NETWORK_INFO)
            println(nw.state)
            if (nw.state == NetworkInfo.State.CONNECTED || nw.state == NetworkInfo.State.DISCONNECTED) {
                println("startService")
                context.startService(Intent(context, MainService::class.java))
            }
        }
    }
}
