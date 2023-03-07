package com.management.hotelapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.management.hotelapplication.dao.MenuDao
import com.management.hotelapplication.table.MenuModel

@Database(entities = [MenuModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): MenuDao
}
