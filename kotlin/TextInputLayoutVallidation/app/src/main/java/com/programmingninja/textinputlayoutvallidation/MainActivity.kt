package com.programmingninja.textinputlayoutvallidation

import android.app.Activity
import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.programmingninja.textinputlayoutvallidation.databinding.ActivityMainBinding
import com.programmingninja.textinputlayoutvallidation.helper.ValidateFormat.validEmailFormat
import com.programmingninja.textinputlayoutvallidation.helper.ValidateFormat.validPasswordFormat
import com.programmingninja.textinputlayoutvallidation.helper.ValidateFormat.validStringFormat
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        layoutListener()

        binding.btnSignup.setOnClickListener {
            //review validation on fields
            if (fieldValidation()) {
                hideKeyboard(it)
                val snacking = Snackbar.make(it, "validated", Snackbar.LENGTH_SHORT)
                snacking.show()
            }
        }
    }

    fun Context.hideKeyboard(view: View) {
        val input = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        input.hideSoftInputFromWindow(view.windowToken, 0)
    }

    //listener for the editText
    private fun layoutListener() {
        binding.txtInputEditEmail.addTextChangedListener(ValidateFieldChange(binding.txtInputEditEmail))
        binding.txtInputEditFname.addTextChangedListener(ValidateFieldChange(binding.txtInputEditFname))
        binding.txtInputEditLname.addTextChangedListener(ValidateFieldChange(binding.txtInputEditLname))
        binding.txtInputEditPass.addTextChangedListener(ValidateFieldChange(binding.txtInputEditPass))
    }

    /**
     * validate fields
     */
    private fun  fieldValidation() : Boolean = validateFirstName() && validateLastName() && validateEmail() && validatePassword()

    /**
     * fields validation that review that the following fields are not empty
     *  - validatePassword (will check that password is not empty)
     *      - make sure user follow password requirement
     *  - validateEmail (will check that email is not empty)
     *      - make sure user use an actual email
     *  - validateName (will check first & last name is not empty)
     *      - make sure user not just putting anything here
     */
    private fun validatePassword(): Boolean {
        if (binding.txtInputEditPass.text.toString().trim().isEmpty()) {
            binding.txtLayoutPass.error = "Excuse me sir, this is a required field"
            binding.txtInputEditPass.requestFocus()
            return false
        } else if (!validPasswordFormat(binding.txtInputEditPass.text.toString())) {
            binding.txtLayoutPass.error = "Excuse me sir, password does not meet expectation"
            binding.txtInputEditPass.requestFocus()
            return false
        } else {
            binding.txtLayoutPass.isErrorEnabled = false
        }
        return true
    }

    private fun validateEmail(): Boolean {
        if (binding.txtInputEditEmail.text.toString().trim().isEmpty()) {
            binding.txtLayoutEmail.error = "Excuse me sir, this is a required field"
            binding.txtInputEditEmail.requestFocus()
            return false
        } else if (!validEmailFormat(binding.txtInputEditEmail.text.toString())) {
            binding.txtLayoutEmail.error = "Excuse me sir, password does not meet expectation"
            binding.txtInputEditEmail.requestFocus()
        } else {
            binding.txtLayoutEmail.isErrorEnabled = false

        }
        return true
    }

    private fun validateFirstName(): Boolean {
        //validate first & last name
        if (binding.txtInputEditFname.text.toString().trim().isEmpty()) {
            binding.txtLayoutFname.error = "Excuse me sir, this is a required field"
            binding.txtInputEditFname.requestFocus()
            return false
        } else if (!validStringFormat(binding.txtInputEditFname.text.toString())) {
            binding.txtLayoutFname.error = "Excuse me sir, password does not meet expectation"
            binding.txtInputEditFname.requestFocus()
        } else {
            binding.txtLayoutFname.isErrorEnabled = false
        }
        return true
    }

    private fun validateLastName(): Boolean {
        //validate first & last name
        if (binding.txtInputEditLname.text.toString().trim().isEmpty()) {
            binding.txtLayoutLname.error = "Excuse me sir, this is a required field"
            binding.txtInputEditLname.requestFocus()
            return false
        } else if (!validStringFormat(binding.txtInputEditLname.text.toString())) {
            binding.txtLayoutLname.error = "Excuse me sir, password does not meet expectation"
            binding.txtInputEditLname.requestFocus()
        } else {
            binding.txtLayoutLname.isErrorEnabled = false
        }
        return true
    }

    /**
     * watch the fields for changes
     */
    inner class ValidateFieldChange(private val view: View) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //check the elements of each fields and apply response.
            when (view.id) {
                R.id.txtInput_edit_fname -> {
                    validateFirstName()
                }
                R.id.txtInput_edit_lname -> {
                    validateLastName()
                }
                R.id.txtInput_edit_email -> {
                    validateEmail()
                }
                R.id.txtInput_edit_pass -> {
                    validatePassword()
                }
            }
        }

        override fun afterTextChanged(s: Editable?) {

        }
    }
}