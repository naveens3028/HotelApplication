package com.management.hotelapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AdminloginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminlogin)
        val fltbtn=findViewById<FloatingActionButton>(R.id.floating_btn)
       fltbtn.setOnClickListener {
            val intent = Intent(this,MenudetailsActivity::class.java)
            startActivity(intent)

        }
    }

        }
