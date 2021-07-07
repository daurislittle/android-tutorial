package com.programmingninja.simplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmingninja.simplerecyclerview.adapter.FarmAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //init an empty arraylist
    val farmAnimals: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add  items to the list we created
        animalCollection()

        //create a vertical layout
        rv_list.layoutManager = LinearLayoutManager(this)

        //to use multiple column use GridLayoutManager
        rv_list.layoutManager = GridLayoutManager(this, 2)

        //access the recyclerview and assign the generated data
        rv_list.adapter = FarmAdapter(farmAnimals, this)
    }

    //this function purupose is simply add items to the ArrayList to display
    fun animalCollection() {

        farmAnimals.add("cat")
        farmAnimals.add("dog")
        farmAnimals.add("cow")
        farmAnimals.add("chicken")
        farmAnimals.add("pig")
        farmAnimals.add("horse")
        farmAnimals.add("goat")
        farmAnimals.add("rooster")
        farmAnimals.add("duck")
        farmAnimals.add("bird")
        farmAnimals.add("sheep")
        farmAnimals.add("rabbit")
        farmAnimals.add("mouse")
    }
}