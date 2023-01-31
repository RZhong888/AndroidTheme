package com.example.usingtheme

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates

const val PREFERENCE_NAME = "setting"
const val PREFERENCE_KEY_THEME_FLAG = "themeFlag"
const val PREFERENCE_KEY_THEME_BASIC = 0
const val PREFERENCE_KEY_THEME_CHALLENGER = 1

class ABTestingActivity: AppCompatActivity(), View.OnClickListener {
    private var currentTheme by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applyTheme()
        setContentView(R.layout.activity_ab_testing)
        findViewById<Button>(R.id.switch_theme_btn).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(R.id.switch_theme_btn == view?.id) {
            var newTheme = PREFERENCE_KEY_THEME_BASIC
            if(currentTheme == PREFERENCE_KEY_THEME_BASIC) {
                newTheme = PREFERENCE_KEY_THEME_CHALLENGER
            }
            setThemeFLag(newTheme)
            finish()
        }
    }

    private fun applyTheme() {
        currentTheme = getThemeFLag()
        if(currentTheme == PREFERENCE_KEY_THEME_BASIC) {
            setTheme(R.style.Theme_UsingTheme)
        } else {
            setTheme(R.style.Theme_UsingTheme_Challenger)
        }
    }

    private fun setThemeFLag(flag: Int) =
        getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE).edit().run {
            putInt(PREFERENCE_KEY_THEME_FLAG, flag)
            commit()
        }

    private fun getThemeFLag(): Int =
        getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE).getInt(PREFERENCE_KEY_THEME_FLAG, PREFERENCE_KEY_THEME_BASIC)
}