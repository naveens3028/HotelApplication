package com.management.hotelapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.management.hotelapplication.table.UserLogin

@Dao
interface NewUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewUser(data:UserLogin)
}