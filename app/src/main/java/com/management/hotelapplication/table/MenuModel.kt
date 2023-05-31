package com.management.hotelapplication.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity
data class MenuModel(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "itemName") var itemName: String?,
    @ColumnInfo(name = "price") var price: String,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "image") var image: String?
) : Parcelable