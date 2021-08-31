package com.programmingninja.textinputlayoutvallidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.programmingninja.textinputlayoutvallidation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.txtInputEditEmail.addTextChangedListener(FieldValidation(binding.txtInputEditEmail))
        binding.txtInputEditFname.addTextChangedListener(FieldValidation(binding.txtInputEditFname))
        binding.txtInputEditLname.addTextChangedListener(FieldValidation(binding.txtInputEditLname))
        binding.txtInputEditPass.addTextChangedListener(FieldValidation(binding.txtInputEditPass))

        binding.btnSignup.setOnClickListener {
            //if statement for validation
            Snackbar.make(it, "validated", Snackbar.LENGTH_SHORT).show()
        }

        setContentView(R.layout.activity_main)
    }

    /**
     * watch the fields for changes
     */
    inner class FieldValidation(private val view: View) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //check the elements of each fields and apply response
        }

        override fun afterTextChanged(s: Editable?) {
            TODO("Not yet implemented")
        }
    }
}