package com.example.camerafinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollerctor.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollerctor.removeActivity(this)
    }
}