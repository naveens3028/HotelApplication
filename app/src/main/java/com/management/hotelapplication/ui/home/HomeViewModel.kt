package com.management.hotelapplication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.model.MenuModel


class HomeViewModel : ViewModel() {

    val myLiveData = MutableLiveData<List<MenuModel>>()

    fun saveDataToDb(data: MenuModel, database: AppDatabase) {
        database.menuDao().updateData(data)
        getDataFromDb(database)
    }

    fun getDataFromDb(database: AppDatabase) {
        myLiveData.value = database.menuDao().getData()
    }

//    fun addDatasToDb(db: AppDatabase, menu: MenuModel) {
//
//        var dataList = ArrayList<MenuModel>()
//        dataList.apply {
//            add(
//                menu
//            )
//           /* add(
//                MenuModel(
//                    itemName = "Idly",
//                    description = "Idly sambar",
//                    image = "https://reqres.in/img/faces/7-image.jpg",
//                    price = 20
//                )
//            )
//            add(
//                MenuModel(
//                    itemName = "Noodles",
//                    description = "Veg noodles",
//                    image = "https://reqres.in/img/faces/7-image.jpg",
//                    price = 80
//                )
//            )*/
//        }.also {
//            db.menuDao().updateData(it)
//        }
//    }

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text
}