package com.example.restaurantapp.fragments.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.restaurantapp.R
import com.example.restaurantapp.model.Profile
import com.example.restaurantapp.repository.ProfileRepository
import com.example.restaurantapp.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment() {

    private lateinit var mProfileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        var profile: Profile? = null

        mProfileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        mProfileViewModel.readAllData.observe(viewLifecycleOwner, Observer { prof ->
            profile = prof[0]

        })
        view.name.text = profile?.name
        view.address.text = profile?.address
        view.prhoneNr.text = profile?.phoneNr
        view.email.text = profile?.email
        Glide.with(requireContext()).load(profile?.image).into(view.image_profile)

        return view
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    
}

