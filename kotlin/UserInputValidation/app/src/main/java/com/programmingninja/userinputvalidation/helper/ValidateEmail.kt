package com.programmingninja.userinputvalidation.helper

import android.text.TextUtils
import androidx.core.text.TextUtilsCompat
import com.programmingninja.userinputvalidation.R
import com.programmingninja.userinputvalidation.helper.validator.BaseValidation
import com.programmingninja.userinputvalidation.helper.validator.Validate

class ValidateEmail(val emailString: String): BaseValidation() {

    override fun validate(): Validate {
        val isValid = !TextUtils.isEmpty(emailString) && android.util.Patterns.EMAIL_ADDRESS.matcher(emailString).matches()

        return Validate(isValid, if (isValid) R.string.txt_validation_success else R.string.txt_validation_email_error)
    }
}