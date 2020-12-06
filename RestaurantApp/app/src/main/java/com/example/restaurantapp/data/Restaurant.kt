package com.example.restaurantapp.data

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_table")
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val address: String,
    val price: Int,
    val image: Image
)


