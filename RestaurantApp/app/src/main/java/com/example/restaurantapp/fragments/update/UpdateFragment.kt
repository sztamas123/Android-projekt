package com.example.restaurantapp.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.restaurantapp.R
import com.example.restaurantapp.model.Restaurant
import com.example.restaurantapp.viewmodel.RestaurantViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mRestaurantViewModel: RestaurantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mRestaurantViewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        view.updateRestaurantName_et.setText(args.currentRestaurant.title)
        view.updateRestaurantAddress_et.setText(args.currentRestaurant.address)
        view.updateRestaurantPrice_et.setText(args.currentRestaurant.price.toString())

        view.update_btn.setOnClickListener{
            updateItem()
        }

        return view
    }

    private fun updateItem(){
        val title = updateRestaurantName_et.text.toString()
        val address = updateRestaurantAddress_et.text.toString()
        val price = Integer.parseInt(updateRestaurantPrice_et.text.toString())

        if (inputCheck(title, address, updateRestaurantPrice_et.text)){
            val updateRestaurant = Restaurant(args.currentRestaurant.id, title, address, price)

            //Update
            mRestaurantViewModel.updateRestaurant(updateRestaurant)
            //Nav back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            Toast.makeText(requireContext(), "Succesfully updated!", Toast.LENGTH_SHORT).show()
        } else{
            Toast.makeText(requireContext(), "Fill out all fields!", Toast.LENGTH_SHORT).show()

        }
    }

    private fun inputCheck(title: String, address: String, price: Editable): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(address) && price.isEmpty())
    }

}