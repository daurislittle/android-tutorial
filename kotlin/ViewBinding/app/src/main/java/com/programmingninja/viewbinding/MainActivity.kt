package com.programmingninja.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.programmingninja.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //create instance ActivityMainBinding
    private lateinit var amb : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //create the instance of ActivityMainBinding
        val binding = ActivityMainBinding.inflate(layoutInflater)

        //binding.root returns the root layout
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val msg = binding.etMessage.text.toString()
            if (!msg.isEmpty()) Snackbar.make(binding.clLayer, binding.etMessage.text.toString(), Snackbar.LENGTH_SHORT).show()
            else Snackbar.make(binding.clLayer, "Message is currently empty", Snackbar.LENGTH_SHORT).show()
        }
    }
}