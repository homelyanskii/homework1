package com.example.homework1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class SecondActivity : AppCompatActivity() {

    val TAG = "SecondActivity"

    val onClickListener = View.OnClickListener {
        Log.d(TAG, "onCLick 2")
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<View>(R.id.test2).setOnClickListener(onClickListener)

    }
}
