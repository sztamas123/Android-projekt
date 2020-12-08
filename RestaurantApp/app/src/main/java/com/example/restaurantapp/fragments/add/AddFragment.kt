package com.example.restaurantapp.fragments.add

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.restaurantapp.R
import com.example.restaurantapp.model.Restaurant
import com.example.restaurantapp.viewmodel.RestaurantViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    private lateinit var mRestaurantViewModel: RestaurantViewModel
    private lateinit var imageUri: Uri
    private lateinit var img: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        img = view.imageView

        mRestaurantViewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        view.add_btn.setOnClickListener{
            insertDataToDatabase()
        }

        view.img_btn.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, 100)
        }

        return view
    }

    private fun insertDataToDatabase(){
        val title = addRestaurantName_et.text.toString()
        val address = addRestaurantAddress_et.text.toString()
        val price = addRestaurantPrice_et.text

        if (inputCheck(title, address, price)){
            val restaurant = Restaurant(
                0,
                title,
                address,
                Integer.parseInt(price.toString()),
                imageUri.toString()
            )

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 100){
            imageUri = data?.data!!
            Glide.with(requireContext()).load(imageUri).into(img)
            Log.d("size",img.width.toString() + "  "+ img.height.toString())
        }
    }
}