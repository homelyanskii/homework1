package com.example.homework1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    var n = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        n = savedInstanceState.getInt("N")
        Log.w(TAG, "${n}")
        Intent(this, SimpleValuesDecompositionService::class.java).also { intent ->
            intent.putExtra("N", n)
            startService(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putInt("N", n + 1)
        Intent(this, SimpleValuesDecompositionService::class.java).also { intent ->
            stopService(intent)
        }
    }
}
