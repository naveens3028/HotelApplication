package com.management.hotelapplication.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.databinding.ActivityNewuserregBinding
import com.management.hotelapplication.table.UserLogin
import org.koin.android.ext.android.inject

class NewUserRegistration : AppCompatActivity() {

    lateinit var binding: ActivityNewuserregBinding
    lateinit var newUserViewModel: NewUserViewModel
    val dat: AppDatabase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewuserregBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newUserViewModel = ViewModelProvider(this).get(NewUserViewModel::class.java)
        binding.save.setOnClickListener {
            val info = UserLogin(
                username = binding.newusername.text.toString(),
                password = binding.newuserpass.text.toString()
            )
            newUserViewModel.updateUserDetails(info, dat)
            finish()
        }

    }
}