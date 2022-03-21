package com.programmingninja.userinputvalidation.helper

import android.text.TextUtils
import androidx.core.text.TextUtilsCompat
import com.programmingninja.userinputvalidation.helper.validator.BaseValidation
import com.programmingninja.userinputvalidation.helper.validator.Validate

class ValidateEmail(val emailString: String): BaseValidation() {

    fun validate(): Validate {
        val isValid = !TextUtils.isEmpty(emailString) && android.util.Patterns.EMAIL_ADDRESS.matcher(emailString).matches()

        return Validate(isValid, if (isValid) "success".hashCode() else "fail".hashCode())
    }
}