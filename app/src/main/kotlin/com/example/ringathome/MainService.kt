package com.example.ringathome

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.net.wifi.WifiManager
import android.os.IBinder

class MainService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("onStartCommand(intent = $intent, flags = $flags, startId = $startId)")
        if (intent != null) {
            val wifi = getSystemService(Context.WIFI_SERVICE) as WifiManager
            val ssid = wifi.connectionInfo.ssid
            val audio = getSystemService(Context.AUDIO_SERVICE) as AudioManager
            audio.ringerMode = if (ssid == "\"******\"") AudioManager.RINGER_MODE_NORMAL else AudioManager.RINGER_MODE_VIBRATE
        }
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }
}
