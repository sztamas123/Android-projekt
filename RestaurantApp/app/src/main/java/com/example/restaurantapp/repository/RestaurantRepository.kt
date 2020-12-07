package com.example.restaurantapp.repository

import androidx.lifecycle.LiveData
import com.example.restaurantapp.data.RestaurantDao
import com.example.restaurantapp.model.Restaurant

class RestaurantRepository(private val restaurantDao: RestaurantDao) {

    val readAllData: LiveData<List<Restaurant>> = restaurantDao.readAllData()

    suspend fun addRestaurant(restaurant: Restaurant){
        restaurantDao.addRestaurant(restaurant)
    }

    suspend fun updateRestaurant(restaurant: Restaurant){
        restaurantDao.updateRestaurant(restaurant)
    }

    suspend fun deleteRestaurant(restaurant: Restaurant){
        restaurantDao.deleteRestaurant(restaurant)
    }

    suspend fun deleteAllRestaurant(){
        restaurantDao.deleteAllRestaurant()
    }
}