package com.example.usingtheme

import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlin.properties.Delegates

class UsingAttrActivity: AppCompatActivity(), View.OnClickListener {
    private var currentTheme by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applyTheme()
        setContentView(R.layout.activity_using_attr_on_the_code_layer)
        findViewById<Button>(R.id.switch_theme_btn).setOnClickListener(this)
        findViewById<Button>(R.id.using_attr_btn).setOnClickListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.using_attr_btn -> {
                findViewById<TextView>(R.id.test_tv)?.apply {
                    val color = getThemeTypeValue(R.attr.textDefault).data
                    setTextColor(color)

                    resources?.run {
                        val size = getThemeTypeValue(R.attr.textDefaultSize).getDimension(displayMetrics)
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
                    }

                    context?.let { innerContext ->
                        val textFamilyId = getThemeTypeValue(R.attr.textDefaultFamily).resourceId
                        val typeface = ResourcesCompat.getFont(innerContext, textFamilyId)
                        setTypeface(typeface)
                    }
                }
            }
            R.id.switch_theme_btn -> {
                var newTheme = PREFERENCE_KEY_THEME_BASIC
                if(currentTheme == PREFERENCE_KEY_THEME_BASIC) {
                    newTheme = PREFERENCE_KEY_THEME_CHALLENGER
                }
                setThemeFLag(newTheme)
                finish()
            }
            else -> Unit
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

    private fun getThemeTypeValue(attrId: Int): TypedValue =
        TypedValue().apply {
            theme.resolveAttribute(attrId, this, true)
        }
}