package com.example.restaurantapp.fragments.update

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.restaurantapp.model.Restaurant
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class UpdateFragmentArgs(
  val currentRestaurant: Restaurant
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): UpdateFragmentArgs {
      bundle.setClassLoader(UpdateFragmentArgs::class.java.classLoader)
      val __currentRestaurant : Restaurant?
      if (bundle.containsKey("currentRestaurant")) {
        if (Parcelable::class.java.isAssignableFrom(Restaurant::class.java) ||
            Serializable::class.java.isAssignableFrom(Restaurant::class.java)) {
          __currentRestaurant = bundle.get("currentRestaurant") as Restaurant?
        } else {
          throw UnsupportedOperationException(Restaurant::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__currentRestaurant == null) {
          throw IllegalArgumentException("Argument \"currentRestaurant\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"currentRestaurant\" is missing and does not have an android:defaultValue")
      }
      return UpdateFragmentArgs(__currentRestaurant)
    }
  }
}
