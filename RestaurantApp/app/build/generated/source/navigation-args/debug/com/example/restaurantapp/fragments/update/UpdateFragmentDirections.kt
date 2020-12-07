package com.example.restaurantapp.fragments.update

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.restaurantapp.R

class UpdateFragmentDirections private constructor() {
  companion object {
    fun actionUpdateFragmentToListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_updateFragment_to_listFragment)
  }
}
