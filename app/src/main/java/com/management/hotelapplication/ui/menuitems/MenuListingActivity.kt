package com.management.hotelapplication.ui.menuitems

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.management.hotelapplication.adapter.CustomAdapter
import com.management.hotelapplication.adapter.CustomAdapterListener
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.databinding.ActivityAdminloginBinding
import com.management.hotelapplication.table.MenuModel
import org.koin.android.ext.android.inject

class MenuListingActivity : AppCompatActivity(),CustomAdapterListener {

    lateinit var binding: ActivityAdminloginBinding
    lateinit var viewModel: MenuViewModel
    lateinit var adapter: CustomAdapter

    val database: AppDatabase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminloginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

        binding.floatingBtn.setOnClickListener {
            val intent = Intent(this, MenuAddItemActivity::class.java)
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

    fun createAdapter(list: List<MenuModel>) {
        val adapter = CustomAdapter(list,this)
        binding.recyclerView.adapter = adapter

    }

    override fun OnItemClick(data:MenuModel) {

        val intent=Intent(this,MenuAddItemActivity::class.java)
        intent.putExtra("itemName",data)
        startActivity(intent)

    }




}
