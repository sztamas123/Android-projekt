package com.example.restaurantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSupoortNavigateUp(): Boolean{
        val navController = findNavController(R.id.fragment)
        return super.onSupportNavigateUp() || super.onSupportNavigateUp()

    }
}