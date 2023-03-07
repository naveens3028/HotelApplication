package com.management.hotelapplication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.table.MenuModel


class HomeViewModel : ViewModel() {

    val myLiveData = MutableLiveData<List<MenuModel>>()

    fun saveDataToDb(data: MenuModel, database: AppDatabase) {
        database.menuDao().updateData(data)
        getDataFromDb(database)
    }

    fun getDataFromDb(database: AppDatabase) {
        myLiveData.value = database.menuDao().getData()
    }

}