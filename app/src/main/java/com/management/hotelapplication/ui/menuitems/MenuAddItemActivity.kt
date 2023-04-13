package com.management.hotelapplication.ui.menuitems

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.management.hotelapplication.R
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



    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenudetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val data: MenuModel? = intent.getParcelableExtra("itemName")
        binding.fname.setText(data?.itemName)
        binding.fdes.setText(data?.description)
        binding.fpric.setText(data?.price)





        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        binding.saveBtn.setOnClickListener {
            if(data==null) {

                val data1 = MenuModel(
                    itemName = binding.fname.text.toString(),
                    description = binding.fdes.text.toString(),
                    price = binding.fpric.text.toString(),
                    image = imageUrl
                )
                menuViewModel.saveData(data1, database)
            }
            else{
                val data2 = data?.id?.let { it1 ->
                    MenuModel(
                        id= it1,

                        itemName = binding.fname.text.toString(),
                        description = binding.fdes.text.toString(),
                        price = binding.fpric.text.toString(),
                        image = imageUrl
                    )
                }
                if (data2 != null) {
                    menuViewModel.saveData(data2, database)
                }

            }
            finish()
        }

        menuViewModel.myLiveData.observe(this, Observer {
            binding.saveBtn.visibility = View.VISIBLE
            binding.editBtn.visibility = View.GONE

        })


        binding.editBtn.setOnClickListener{

            val edit_btn= findViewById<ImageButton>(R.id.edit_btn);
            edit_btn.setEnabled(true);
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