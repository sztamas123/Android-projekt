package com.example.restaurantapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.restaurantapp.R
import com.example.restaurantapp.data.Restaurant
import com.example.restaurantapp.data.RestaurantViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    private lateinit var mRestaurantViewModel: RestaurantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        mRestaurantViewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        view.add_btn.setOnClickListener{
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase(){
        val title = addRestaurantName_et.text.toString()
        val address = addRestaurantAddress_et.text.toString()
        val price = addRestaurantPrice_et.text

        if (inputCheck(title, address, price)){
            val restaurant = Restaurant(0, title, address, Integer.parseInt(price.toString()))

            mRestaurantViewModel.addRestaurant(restaurant)
            Toast.makeText(requireContext(), "Succesfully added new restaurant!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG).show()

        }
    }

    private fun inputCheck(title: String, address: String, price: Editable): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(address) && price.isEmpty())
    }

}