package com.example.usingtheme

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ThemeOverlayTwoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_UsingTheme)
        setContentView(R.layout.activity_theme_overlay_two)
        importOtherLayout()
    }

    private fun importOtherLayout() {
        findViewById<LinearLayout>(R.id.basic_theme_container_ll).apply {
            importView(this)
        }

        findViewById<LinearLayout>(R.id.challenger_theme_container_ll).apply {
//            R.style.Theme_UsingTheme_Challenger
//            R.style.Theme_UsingTheme
            setTheme(R.style.Theme_UsingTheme_Challenger)
            importView(this)
        }
    }

    private fun importView(rootView: ViewGroup): View = layoutInflater.inflate(R.layout.layout_import, rootView, true)
}