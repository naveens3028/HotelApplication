package com.management.hotelapplication.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.database.DatabaseBuilder
import com.management.hotelapplication.databinding.ActivityUserloginBinding
import com.management.hotelapplication.table.UserLogin
import com.management.hotelapplication.ui.splash.SplashScreenActivity

class UserLoginActivity() : AppCompatActivity() {

    lateinit var binding: ActivityUserloginBinding
    lateinit var userloginViewModel: UserLoginViewModel
    lateinit var db: AppDatabase
    lateinit var user_name: String
    lateinit var passwrd: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserloginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DatabaseBuilder.getInstance(this)
        userloginViewModel = ViewModelProvider(this).get(UserLoginViewModel::class.java)

        binding.submit.setOnClickListener {
            user_name = binding.username.text.toString()
            passwrd = binding.password.text.toString()
            if (user_name.isNullOrEmpty() || passwrd.isNullOrEmpty()) {
                Toast.makeText(this, "Enter valid username or Password", Toast.LENGTH_SHORT).show()
            } else {
                val data = UserLogin(
                    username = binding.username.text.toString(),
                    password = binding.password.text.toString()
                )
                userloginViewModel.checkValidcreds(data, db)
            }
        }


        userloginViewModel.liveDataLogin.observe(this, Observer {
            if (it) {
                startActivity(Intent(this, SplashScreenActivity::class.java))
            } else {
                Toast.makeText(this, "Enter valid UserName or Password", Toast.LENGTH_SHORT).show()
            }
        })

        binding.registernow.setOnClickListener {

            val intent = Intent(this, NewUserRegistration::class.java)
            startActivity(intent)
        }

    }
}


   







