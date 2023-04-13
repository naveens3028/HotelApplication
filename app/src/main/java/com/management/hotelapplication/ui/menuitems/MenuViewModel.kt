package com.management.hotelapplication.ui.menuitems

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.table.MenuModel

class MenuViewModel : ViewModel() {

    val myLiveData = MutableLiveData<List<MenuModel>>()
    val errorMsg = MutableLiveData<String>()

    fun saveData(data: MenuModel, database: AppDatabase) {

        database.menuDao().updateData(data)

    }

    fun getDataFromDb(database: AppDatabase) {
        val data = database.menuDao().getData()
        if (!data.isNullOrEmpty()) {
            myLiveData.value = data
        } else {
            errorMsg.value = "No Data's Found"
        }
    }
        fun fetchDataFromDb(database: AppDatabase){

            database.menuDao().getMenuDetails()


        }

}