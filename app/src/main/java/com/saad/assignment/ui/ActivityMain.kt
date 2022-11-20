package com.saad.assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saad.assignment.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityMain : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}