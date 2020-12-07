package com.example.restaurantapp.fragments.list

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.restaurantapp.R
import com.example.restaurantapp.model.Restaurant
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class ListFragmentDirections private constructor() {
  private data class ActionListFragmentToUpdateFragment(
    val currentRestaurant: Restaurant
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_listFragment_to_updateFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Restaurant::class.java)) {
        result.putParcelable("currentRestaurant", this.currentRestaurant as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(Restaurant::class.java)) {
        result.putSerializable("currentRestaurant", this.currentRestaurant as Serializable)
      } else {
        throw UnsupportedOperationException(Restaurant::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionListFragmentToAddFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listFragment_to_addFragment)

    fun actionListFragmentToUpdateFragment(currentRestaurant: Restaurant): NavDirections =
        ActionListFragmentToUpdateFragment(currentRestaurant)
  }
}
