package com.programmingninja.userinputvalidation.helper

import com.programmingninja.userinputvalidation.R
import com.programmingninja.userinputvalidation.helper.validator.BaseValidation
import com.programmingninja.userinputvalidation.helper.validator.Validate

class ValidateEmpty(val input: String): BaseValidation() {
    override fun validate(): Validate {
        val isValid = input.isNotEmpty()
        return Validate(isValid, if (isValid) R.string.txt_validation_success else R.string.txt_validation_error)
    }
}