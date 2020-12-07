package com.example.restaurantapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.restaurantapp.data.RestaurantDatabase
import com.example.restaurantapp.repository.RestaurantRepository
import com.example.restaurantapp.model.Restaurant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RestaurantViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Restaurant>>
    private val repository: RestaurantRepository

    init {
        val restaurantDao = RestaurantDatabase.getDatabase(
            application
        ).restaurantDao()
        repository =
            RestaurantRepository(
                restaurantDao
            )
        readAllData = repository.readAllData
    }

    fun addRestaurant(restaurant: Restaurant){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRestaurant(restaurant)
        }
    }

    fun updateRestaurant(restaurant: Restaurant){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateRestaurant(restaurant)
        }
    }
}