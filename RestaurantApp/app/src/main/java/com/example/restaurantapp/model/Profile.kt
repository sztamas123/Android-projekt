package com.example.restaurantapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "profile_table")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: String,
    val address: String,
    val phoneNr: String,
    val email: String
) : Parcelable
