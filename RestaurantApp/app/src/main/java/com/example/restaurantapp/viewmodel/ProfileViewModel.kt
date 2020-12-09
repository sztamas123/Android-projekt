package com.example.restaurantapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.restaurantapp.data.ProfileDatabase
import com.example.restaurantapp.model.Profile
import com.example.restaurantapp.model.Restaurant
import com.example.restaurantapp.repository.ProfileRepository
import com.example.restaurantapp.repository.RestaurantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application): AndroidViewModel(application){
    private val repository: ProfileRepository

    val readAllData: LiveData<List<Profile>>

    init {
        val profileDao = ProfileDatabase.getDatabase(
            application).profileDao()
        repository = ProfileRepository(profileDao)

        readAllData = repository.readAllData
    }



    fun getProfile(name: String, address: String): Profile{
        return repository.getProfile(name, address)
    }

    fun addProfile(profile: Profile){
        viewModelScope.launch(Dispatchers.IO){
            repository.addProfile(profile)
        }
    }



}