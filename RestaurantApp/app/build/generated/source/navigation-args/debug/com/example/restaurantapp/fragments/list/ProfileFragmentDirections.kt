package com.example.restaurantapp.fragments.list

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.restaurantapp.R

class ProfileFragmentDirections private constructor() {
  companion object {
    fun actionProfileFragmentToListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profileFragment_to_listFragment)

    fun actionProfileFragmentToAddProfileFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profileFragment_to_addProfileFragment)
  }
}
