package com.programmingninja.userinputvalidation.helper

import com.programmingninja.userinputvalidation.helper.validator.BaseValidation
import com.programmingninja.userinputvalidation.helper.validator.Validate

class ValidatePassword(val pass: String) : BaseValidation() {

    val minLength = 6
    val maxLength = 32

    fun validate(): Validate {
        if (pass.length < minLength) return Validate(true, "too little".hashCode())
        if (pass.length > maxLength) return  Validate(true, "too many".hashCode())

        return Validate(true, "success".hashCode())
    }
}