package com.example.restaurantapp.fragments.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.restaurantapp.R
import com.example.restaurantapp.data.SqLiteHandler
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val sqlite = SqLiteHandler(requireContext())
        val profile = sqlite.getProfile()!!
        view.name.text = "name: ${profile.name}"
        view.email.text = "email: ${profile.email}"
        view.address.text = ":address: ${profile.address}"
        view.prhoneNr.text = "phoneNumber: ${profile.phoneNumber}"
        Glide.with(requireContext()).load(profile.image).into(view.image_profile)

        view.btn_modify.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_addProfileFragment)
        }

        return view
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }


    
}

