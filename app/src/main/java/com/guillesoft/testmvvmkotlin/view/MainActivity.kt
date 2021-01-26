package com.guillesoft.testmvvmkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guillesoft.testmvvmkotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}