package com.example.restaurantapp.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.restaurantapp.data.ProfileDao
import com.example.restaurantapp.model.Profile

class ProfileRepository(private val profileDao: ProfileDao) {

    val readAllData: LiveData<List<Profile>> = profileDao.readAllData()

    suspend fun addProfile(profile: Profile){
        profileDao.addProfile(profile)
    }

    fun getProfile(name: String, address: String): Profile{
        return profileDao.getProfile(name, address)
    }




}