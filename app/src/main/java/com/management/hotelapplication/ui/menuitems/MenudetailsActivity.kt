package com.management.hotelapplication.ui.menuitems

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.databinding.ActivityMenudetailsBinding
import com.management.hotelapplication.database.DatabaseBuilder
import com.management.hotelapplication.table.MenuModel
import com.management.hotelapplication.ui.camera.CameraActivity
import com.management.hotelapplication.utils.AppUtils
import com.management.hotelapplication.viewmodel.MenuViewModel

class MenudetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenudetailsBinding
    lateinit var menuViewModel:MenuViewModel
    lateinit var  database:AppDatabase
    private var imageUrl: String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenudetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = DatabaseBuilder.getInstance(this)

        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        binding.saveBtn.setOnClickListener {
            val data = MenuModel(
                itemName = binding.fname.text.toString(),
                description = binding.fdes.text.toString(),
                price = this.binding.fpric.text.toString(),
                image = imageUrl
            )
            menuViewModel.saveData(data, database)
            finish()
        }

        binding.menuImgView.setOnClickListener {
            val i = Intent(this, CameraActivity::class.java)
            startActivityForResult(i, AppUtils.LAUNCH_CAMERA_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode ==  AppUtils.LAUNCH_CAMERA_ACTIVITY) {
            imageUrl = data?.getStringExtra("source")
            Glide.with(this).load(imageUrl).into(binding.menuImgView)
        }
    }
}