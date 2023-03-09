package com.example.usingtheme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ForceDarkActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_UsingTheme)
        setContentView(R.layout.activity_force_dark)
    }
}