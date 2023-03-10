package com.management.hotelapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.management.hotelapplication.dao.MenuDao
import com.management.hotelapplication.dao.NewUserDao
import com.management.hotelapplication.dao.UserloginDao
import com.management.hotelapplication.table.MenuModel
import com.management.hotelapplication.table.UserLogin


@Database(entities = [MenuModel::class,UserLogin::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): MenuDao
    abstract fun userloginDao():UserloginDao
    abstract fun newUserDao():NewUserDao

}
