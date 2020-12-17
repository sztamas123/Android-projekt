package com.example.restaurantapp.fragments.add

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.restaurantapp.R

class AddProfileFragmentDirections private constructor() {
  companion object {
    fun actionAddProfileFragmentToProfileFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addProfileFragment_to_profileFragment)
  }
}
