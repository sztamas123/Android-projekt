package com.example.restaurantapp.fragments.add

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.restaurantapp.R
import com.example.restaurantapp.data.SqLiteHandler
import com.example.restaurantapp.model.Profile
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.fragment_add_profile.*
import kotlinx.android.synthetic.main.fragment_add_profile.view.*


class AddProfileFragment : Fragment() {

    private lateinit var imageUri: Uri
    private lateinit var img: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_profile, container, false)

        view.prof_btn.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, 100)
        }

        img = view.prof_img

        view.prof_save_btn.setOnClickListener{
            insertProfile()
            findNavController().navigate(R.id.action_addProfileFragment_to_profileFragment)
        }


        return view
    }

    //Add profile to databse method
    fun insertProfile(){
        val name = prof_name.text.toString()
        val address = prof_address.text.toString()
        val email = prof_email.text.toString()
        val phoneNr = prof_phoneNr.text.toString()


        val profile = Profile(
            name,
            imageUri.toString(),
            address,
            phoneNr,
            email

        )

        val sqlite = SqLiteHandler(requireContext())
        if (sqlite.getProfile() == null){
            sqlite.addProfile(profile)
        } else {
            sqlite.updateProfile(profile)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 100){
            imageUri = data?.data!!
            Glide.with(requireContext()).load(imageUri).into(img)
            //Log.d("size",img.width.toString() + "  "+ img.height.toString())
        }
    }

}