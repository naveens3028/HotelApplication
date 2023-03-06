package com.management.hotelapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.model.MenuModel

class MenuViewModel:ViewModel() {

    val myLiveData=MutableLiveData<List<MenuModel>>()

    fun saveData(data: MenuModel, database: AppDatabase) {
        database.menuDao().updateData(data)
    }

    fun getDataFromDb(database: AppDatabase) {
    myLiveData.value=database.menuDao().getData()
    }

}