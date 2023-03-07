package com.management.hotelapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.databinding.ActivityAdminloginBinding
import com.management.hotelapplication.model.DatabaseBuilder
import com.management.hotelapplication.model.MenuModel
import com.management.hotelapplication.viewmodel.MenuViewModel

class AdminloginActivity : AppCompatActivity() {

    lateinit var binding: ActivityAdminloginBinding
    lateinit var viewModel: MenuViewModel
    lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminloginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = DatabaseBuilder.getInstance(this)

        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

       binding.floatingBtn.setOnClickListener {
            val intent = Intent(this,MenudetailsActivity::class.java)
            startActivity(intent)
       }

        viewModel.myLiveData.observe(this, Observer {
            binding.recyclerView.visibility = View.VISIBLE
            binding.txtView.visibility = View.GONE
            createAdapter(it)
        })

        viewModel.errorMsg.observe(this, Observer {
            binding.recyclerView.visibility = View.GONE
            binding.txtView.visibility = View.VISIBLE
            binding.txtView.text = it
        })

    }

    override fun onResume() {
        super.onResume()
        viewModel.getDataFromDb(database = database)
    }

    fun createAdapter(list : List<MenuModel>){
        val adapter = CustomAdapter(list)
        binding.recyclerView.adapter =adapter
    }


}
