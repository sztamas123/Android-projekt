package com.example.restaurantapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.restaurantapp.model.Profile


@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProfile(profile: Profile)

    @Query("SELECT * FROM  profile_table ORDER BY id ASC")
    fun readALlData(): LiveData<List<Profile>>

    @Query("SELECT * FROM profile_table WHERE name == name AND address == address")
    fun getProfile(name: String, address: String) :Profile


}