package com.management.hotelapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.management.hotelapplication.model.MenuModel

@Dao
interface MenuDao {

    @Query("SELECT * FROM MenuModel")
    fun getData() : List<MenuModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateData(data: MenuModel)

}