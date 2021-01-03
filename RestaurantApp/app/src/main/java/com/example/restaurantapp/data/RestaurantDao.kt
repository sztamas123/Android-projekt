package com.example.restaurantapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.restaurantapp.model.Restaurant

//DAO - data acces object
//Methods used to acces the database


@Dao
interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRestaurant(restaurant: Restaurant)

    @Query("SELECT * FROM  restaurant_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Restaurant>>

    @Update
    suspend fun updateRestaurant(restaurant: Restaurant)

    @Delete
    suspend fun deleteRestaurant(restaurant: Restaurant)

    @Query("DELETE FROM restaurant_table")
    suspend fun deleteAllRestaurant()

}