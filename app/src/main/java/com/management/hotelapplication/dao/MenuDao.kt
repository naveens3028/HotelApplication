package com.management.hotelapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.management.hotelapplication.table.MenuModel
import com.management.hotelapplication.table.UserLogin

@Dao
interface MenuDao {
    @Query("SELECT * FROM MenuModel")
    fun getData() : List<MenuModel>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateData(data: MenuModel)

    @Query("SELECT * FROM MenuModel ")
    fun getMenuDetails():List<MenuModel>

}