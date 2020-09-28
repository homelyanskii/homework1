package com.example.homework1

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

private const val TAG = "Service"

class SimpleValuesDecompositionService : Service() {
    var result = ""

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
    }

//    Not execute in startService
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        return super.onStartCommand(intent, flags, startId)
//        Log.d(TAG, "onStartCommand")
//    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)

        var n = 0

        if (intent != null) {
            n = intent.getIntExtra("N", n)
        }

        var result = ""
        var num = n * 10

        while (num > 1){
            for ( i in 2..num ){
                if ( num % i == 0 ) {
                    num /= i
                    result += "${i} "
                    break
                }
            }
        }

        Intent().also {intent ->
            intent.setAction("com.example.homework1.broadcast.HELP")
            intent.putExtra("data", result)
            sendBroadcast(intent)
        }

    }
}
