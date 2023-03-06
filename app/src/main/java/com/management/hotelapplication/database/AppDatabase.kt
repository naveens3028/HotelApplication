package com.management.hotelapplication.database

import android.text.Editable
import androidx.room.Database
import androidx.room.RoomDatabase
import com.management.hotelapplication.dao.MenuDao
import com.management.hotelapplication.model.MenuModel

@Database(entities = [MenuModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun menuDao(): MenuDao

}
