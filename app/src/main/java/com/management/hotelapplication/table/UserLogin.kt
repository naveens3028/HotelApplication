package com.management.hotelapplication.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserLogin(
    @PrimaryKey(autoGenerate = true) var id:Int=0,
    @ColumnInfo(name = "username") var username:String?,
    @ColumnInfo(name = "password") var password:String?
    )
