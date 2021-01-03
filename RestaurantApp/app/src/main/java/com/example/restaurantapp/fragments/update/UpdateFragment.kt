package com.example.restaurantapp.fragments.update

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.restaurantapp.R
import com.example.restaurantapp.model.Restaurant
import com.example.restaurantapp.viewmodel.RestaurantViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mRestaurantViewModel: RestaurantViewModel
    private lateinit var imageUri: Uri
    private lateinit var img: ImageView

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
        view.btn_update.setOnClickListener{
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, 100)
        }
        img = view.imageViewUpdate

        view.update_btn.setOnClickListener{
            updateItem()
        }

        //Add menu
        setHasOptionsMenu(true)


        return view
    }

    //Update restaurant method
    private fun updateItem(){
        val title = updateRestaurantName_et.text.toString()
        val address = updateRestaurantAddress_et.text.toString()
        val price = Integer.parseInt(updateRestaurantPrice_et.text.toString())
        val image = imageUri.toString()

        if (inputCheck(title, address, updateRestaurantPrice_et.text, image)){
            //Create resturant object
            val updateRestaurant = Restaurant(args.currentRestaurant.id, title, address, price, image)
            //Update restaurant
            mRestaurantViewModel.updateRestaurant(updateRestaurant)
            //Navigate back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            Toast.makeText(requireContext(), "Succesfully updated!", Toast.LENGTH_SHORT).show()
        } else{
            Toast.makeText(requireContext(), "Fill out all fields!", Toast.LENGTH_SHORT).show()

        }
    }

    //Check if input is correct
    private fun inputCheck(title: String, address: String, price: Editable, image: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(address) && price.isEmpty() && TextUtils.isEmpty(image))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    //Handle clicks on delete menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deleteRestaurant()
        }
        return super.onOptionsItemSelected(item)
    }

    //Delte restaurant from database method
    private fun deleteRestaurant() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_, _ ->
            mRestaurantViewModel.deleteRestaurant(args.currentRestaurant)
            Toast.makeText(requireContext(), "Succesfully removed: ${args.currentRestaurant.title}",Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No"){_, _ -> }
        builder.setTitle("Delete ${args.currentRestaurant.title}?")
        builder.setMessage("Are you sure you want to delete ${args.currentRestaurant.title}?")
        builder.create().show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 100){
            imageUri = data?.data!!
            Glide.with(requireContext()).load(imageUri).into(img)
            Log.d("size",img.width.toString() + "  "+ img.height.toString())
        }
    }

}