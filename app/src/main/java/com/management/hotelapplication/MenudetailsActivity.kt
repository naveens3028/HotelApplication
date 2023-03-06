package com.management.hotelapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.databinding.ActivityMenudetailsBinding
import com.management.hotelapplication.model.MenuModel
import com.management.hotelapplication.viewmodel.MenuViewModel

class MenudetailsActivity() : AppCompatActivity()
{
    lateinit var binding: ActivityMenudetailsBinding
    lateinit var menuViewModel:MenuViewModel
    lateinit var  database:AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenudetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        binding.saveBtn.setOnClickListener {
            val data = MenuModel(
                itemName = binding.fname.text.toString(),
                description = binding.fdes.text.toString(),
                price = this.binding.fpric.text.toString(), image = " "
            )
            menuViewModel.saveData(data, database)

        }
            menuViewModel.getDataFromDb(database)

    }
}