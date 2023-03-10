package com.management.hotelapplication.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.database.DatabaseBuilder
import com.management.hotelapplication.databinding.ActivityUserloginBinding
import com.management.hotelapplication.table.UserLogin

class Userlogin() : AppCompatActivity() {

    lateinit var binding: ActivityUserloginBinding
    lateinit var userloginViewModel: UserloginViewModel
    lateinit var db: AppDatabase
    lateinit var user_name: String
    lateinit var passwrd: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserloginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DatabaseBuilder.getInstance(this)
        userloginViewModel = ViewModelProvider(this).get(UserloginViewModel::class.java)

        binding.submit.setOnClickListener {


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


        binding.registernow.setOnClickListener {

            val intent = Intent(this, NewuserRegistration::class.java)
            startActivity(intent)
        }

    }
}


   







