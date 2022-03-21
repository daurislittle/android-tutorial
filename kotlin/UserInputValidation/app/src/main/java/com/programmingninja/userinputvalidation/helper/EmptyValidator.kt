package com.programmingninja.userinputvalidation.helper

import com.programmingninja.userinputvalidation.helper.validator.BaseValidation
import com.programmingninja.userinputvalidation.helper.validator.Validate

class EmptyValidator(val input: String): BaseValidation() {
    fun validate(): Validate {
        val isValid = input.isNotEmpty()
        return Validate(isValid, if (isValid) "success".hashCode() else "right".hashCode())
    }
}