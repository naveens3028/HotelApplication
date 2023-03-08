package com.management.hotelapplication.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.management.hotelapplication.R
import com.management.hotelapplication.databinding.ActivitySplashBinding
import com.management.hotelapplication.ui.menuitems.MenuListingActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        lifecycleScope.launch(Dispatchers.Main) {
            val animation: Animation =
                AnimationUtils.loadAnimation(applicationContext, R.drawable.animator)
            animation.interpolator = LinearInterpolator()
            animation.repeatCount = Animation.INFINITE
            animation.duration = 900

            binding.imgLogo.startAnimation(animation)
            delay(2000L)
            navigateToHome()
        }
    }

    fun navigateToHome() {
        val intent = Intent(this, MenuListingActivity::class.java)
        startActivity(intent)
        finish()
    }

}