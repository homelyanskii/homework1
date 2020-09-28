package com.example.homework1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import android.R

private const val TAG = "DecompositionReceiver"

class DecompositionResultsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var data = intent.getStringExtra("data")
        Toast.makeText(context, data, Toast.LENGTH_LONG).show()
        Log.d(TAG, data)
    }
}
