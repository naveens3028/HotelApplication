package com.management.hotelapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.management.hotelapplication.databinding.ActivitySplashBinding
import com.management.hotelapplication.ui.menuitems.MenuListingActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.Main) {
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