package com.management.hotelapplication.ui.menuitems

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.databinding.ActivityMenudetailsBinding
import com.management.hotelapplication.table.MenuModel
import com.management.hotelapplication.ui.camera.CameraActivity
import com.management.hotelapplication.utils.AppUtils
import org.koin.android.ext.android.inject

class MenuAddItemActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenudetailsBinding
    lateinit var menuViewModel: MenuViewModel
    val database: AppDatabase by inject()
    private var imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenudetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("id", 0)

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
        if (resultCode == Activity.RESULT_OK && requestCode == AppUtils.LAUNCH_CAMERA_ACTIVITY) {
            imageUrl = data?.getStringExtra("source")
            Glide.with(this).load(imageUrl).into(binding.menuImgView)
        }
    }
}