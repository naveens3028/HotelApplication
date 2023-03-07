package com.management.hotelapplication.model

import android.content.Context
import androidx.room.Room
import com.management.hotelapplication.database.AppDatabase

object  DatabaseBuilder  {
    private var INSTANCE:AppDatabase?=null
    fun getInstance(context: Context):AppDatabase{
        synchronized(AppDatabase::class)
        {
            INSTANCE=buildRoomDb(context)
        }

        return INSTANCE!!

    }
    private fun buildRoomDb(context: Context)=
        Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java,"mydata"
        ).allowMainThreadQueries().build()
}