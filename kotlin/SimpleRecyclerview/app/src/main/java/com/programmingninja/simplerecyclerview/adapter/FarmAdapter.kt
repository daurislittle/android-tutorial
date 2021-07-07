package com.programmingninja.simplerecyclerview.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//allow the system to create the needed functions
class FarmAdapter (val items : MutableList<String>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //inflate the items in
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    //bind the animal from the list to a view
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    //get the number of animals in the list
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}