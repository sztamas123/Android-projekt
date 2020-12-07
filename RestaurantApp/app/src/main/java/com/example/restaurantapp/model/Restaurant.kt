package com.example.restaurantapp.model

import android.media.Image
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "restaurant_table")
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val address: String,
    val price: Int
    //val image: Image
): Parcelable


