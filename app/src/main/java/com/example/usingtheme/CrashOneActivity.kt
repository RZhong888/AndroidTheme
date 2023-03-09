package com.example.usingtheme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CrashOneActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Test)
        setContentView(R.layout.activity_crash_one)
    }
}