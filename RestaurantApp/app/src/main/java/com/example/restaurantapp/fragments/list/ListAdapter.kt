package com.example.restaurantapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurantapp.R
import com.example.restaurantapp.model.Restaurant
import kotlinx.android.synthetic.main.custom_row.view.*

//Recycler view adapter

class ListAdapter(private val context: Fragment): RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var restaurantList = emptyList<Restaurant>()


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = restaurantList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.title_txt.text = currentItem.title
        holder.itemView.address_txt.text = currentItem.address
        holder.itemView.price_txt.text = currentItem.price.toString()
        Glide.with(context).load(currentItem.image).into(holder.itemView.imageVIewList)
        

        //Pass restaurant object to update fragment
        holder.itemView.rowLayout.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(restaurant: List<Restaurant>){
        this.restaurantList = restaurant
        notifyDataSetChanged()
    }
}