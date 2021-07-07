package com.programmingninja.simplerecyclerview.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.programmingninja.simplerecyclerview.R
import kotlinx.android.synthetic.main.activity_farm_adapter.view.*

class FarmAdapter(val items : MutableList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    //inflate the items in
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_farm_adapter, parent,false))

    }

    //bind the animal from the list to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.farm_Animal.text = items[position]
    }


    //get the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }


}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    //holds the appcompattextview that will add each animal
    val farm_Animal = view.tv_item
}