package com.management.hotelapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.management.hotelapplication.table.MenuModel
import com.management.hotelapplication.table.UserLogin

@Dao
interface UserloginDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(data: UserLogin)

    @Query("SELECT * FROM UserLogin WHERE username LIKE :username AND password LIKE :password")
    fun getLoginDetails(username: String?, password: String?): UserLogin?



}