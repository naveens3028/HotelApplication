package com.management.hotelapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MenuModel(
    @PrimaryKey(autoGenerate = true) var id: Int=0,
    @ColumnInfo(name = "itemName") var itemName: String?,
    @ColumnInfo(name = "price") var price: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "image") var image: String?
)