package com.programmingninja.userinputvalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.programmingninja.userinputvalidation.databinding.ActivityMainBinding
import com.programmingninja.userinputvalidation.helper.EmptyValidator
import com.programmingninja.userinputvalidation.helper.ValidateEmail
import com.programmingninja.userinputvalidation.helper.ValidatePassword
import com.programmingninja.userinputvalidation.helper.validator.BaseValidation

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val parent = binding.root
        setContentView(parent)

        binding.btnRegister.setOnClickListener {
            noteToUser(parent, R.string.txt_layout_missing)
        }

        binding.btnSignUp.setOnClickListener {
            val usernameInput = binding.ietUsername.text.toString().trim()
            val userValidationCheck = EmptyValidator(usernameInput).validate()
            binding.tilUserName.error = if (!userValidationCheck.status) getString(userValidationCheck.msg) else null

            val firstNameInput = binding.ietFirstname.text.toString().trim()
            val firstValidationCheck = EmptyValidator(firstNameInput).validate()
            binding.tilFirstName.error = if (!firstValidationCheck.status) getString(firstValidationCheck.msg) else null

            val lastNameInput = binding.ietLastname.text.toString().trim()
            val lastValidationCheck = EmptyValidator(lastNameInput).validate()
            binding.tilLastName.error = if (!lastValidationCheck.status) getString(lastValidationCheck.msg) else null

            val passwordInput = binding.ietPass.text.toString().trim()
            val cPasswordInput = binding.ietPassConfirm.text.toString().trim()
            val passValidationCheck = BaseValidation.validate(EmptyValidator(passwordInput), ValidatePassword(passwordInput))
            if (passwordInput == cPasswordInput)  {
                binding.tilPass.error = if (!passValidationCheck.status) getString(passValidationCheck.msg) else null
            } else {
                binding.tilPassConfirm.error = getString(R.string.txt_validation_pass_error_mismatch)
            }

            val emailInput = binding.ietEmail.text.toString().trim()
            val emailValidationCheck = BaseValidation.validate(EmptyValidator(emailInput), ValidateEmail(emailInput))
            binding.tilEmail.error = if (!emailValidationCheck.status) getString(emailValidationCheck.msg) else null

        }


    }


    private fun noteToUser(view: View, msg: Int) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show()
    }
}