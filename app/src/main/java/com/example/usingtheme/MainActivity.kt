package com.example.usingtheme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_UsingTheme)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.switch_mode_btn)?.setOnClickListener(this)
        findViewById<Button>(R.id.ab_testing_btn)?.setOnClickListener(this)
        findViewById<Button>(R.id.using_style_btn)?.setOnClickListener(this)
        findViewById<Button>(R.id.using_attr_btn)?.setOnClickListener(this)
        findViewById<Button>(R.id.theme_overlay_btn)?.setOnClickListener(this)
        findViewById<Button>(R.id.theme_overlay_two_btn)?.setOnClickListener(this)
        findViewById<Button>(R.id.force_dark_btn)?.setOnClickListener(this)
        findViewById<Button>(R.id.crash_one_btn)?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.switch_mode_btn -> navigateToSwitchModeDemo()
            R.id.ab_testing_btn -> navigateToABTestingDemo()
            R.id.using_style_btn -> navigateToUsingStyleDemo()
            R.id.using_attr_btn -> navigateToUsingAttrDemo()
            R.id.theme_overlay_btn -> navigateToThemeOverlayDemo()
            R.id.theme_overlay_two_btn -> navigateToThemeOverlayDemo2()
            R.id.force_dark_btn -> navigateToForceDarkDemo()
            R.id.crash_one_btn -> navigateToCrashOneDemo()
            else -> Unit
        }
    }

    private fun navigateToSwitchModeDemo() =
        startActivity(
            Intent(this, SwitchModeActivity::class.java)
        )

    private fun navigateToABTestingDemo() =
        startActivity(
            Intent(this, ABTestingActivity::class.java)
        )

    private fun navigateToUsingStyleDemo() =
        startActivity(
            Intent(this, UsingStyleActivity::class.java)
        )

    private fun navigateToUsingAttrDemo() =
        startActivity(
            Intent(this, UsingAttrActivity::class.java)
        )

    private fun navigateToThemeOverlayDemo() =
        startActivity(
            Intent(this, ThemeOverlayActivity::class.java)
        )

    private fun navigateToThemeOverlayDemo2() =
        startActivity(
            Intent(this, ThemeOverlayTwoActivity::class.java)
        )

    private fun navigateToForceDarkDemo() =
        startActivity(
            Intent(this, ForceDarkActivity::class.java)
        )

    private fun navigateToCrashOneDemo() =
        startActivity(
            Intent(this, CrashOneActivity::class.java)
        )
}