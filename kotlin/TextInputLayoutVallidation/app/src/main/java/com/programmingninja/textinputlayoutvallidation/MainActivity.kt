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

        binding.txtInputEditEmail.addTextChangedListener(ValidateFieldChange(binding.txtInputEditEmail))
        binding.txtInputEditFname.addTextChangedListener(ValidateFieldChange(binding.txtInputEditFname))
        binding.txtInputEditLname.addTextChangedListener(ValidateFieldChange(binding.txtInputEditLname))
        binding.txtInputEditPass.addTextChangedListener(ValidateFieldChange(binding.txtInputEditPass))

        binding.btnSignup.setOnClickListener {

            //review validation on fields
            if (fieldValidation()) {
                Snackbar.make(it, "validated", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * validate fields
     */

    private fun  fieldValidation() : Boolean = validateName() && validateEmail() && validatePassword()

    /**
     * fields validation that review that the following fields are not empty
     *  - validatePassword (will check that password is not empty)
     *  - validateEmail (will check that email is not empty)
     *  - validateName (will check first & last name is not empty)
     */
    private fun validatePassword(): Boolean {
        if (binding.txtInputEditPass.text.toString().trim().isEmpty()) {

            return false
        } else {

        }
        return true
    }

    private fun validateEmail(): Boolean {
        if (binding.txtInputEditEmail.text.toString().trim().isEmpty()) {

            return false
        } else {
           
        }
        return true
    }

    private fun validateName(): Boolean {

        if (binding.txtInputEditFname.text.toString().trim().isEmpty()) {

            return false
        } else if (binding.txtInputEditLname.text.toString().trim().isEmpty()) {

            return false
        } else {

        }
        return true
    }

    /**
     * watch the fields for changes
     */
    inner class ValidateFieldChange(private val view: View) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //check the elements of each fields and apply response.
            TODO("Not yet implemented")
        }

        override fun afterTextChanged(s: Editable?) {
            TODO("Not yet implemented")
        }
    }
}