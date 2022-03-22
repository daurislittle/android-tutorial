package com.programmingninja.userinputvalidation.helper.validator

import com.programmingninja.userinputvalidation.helper.EmptyValidator
import com.programmingninja.userinputvalidation.helper.ValidateEmail

abstract class BaseValidation: IValidator {
    companion object {
        fun validate(vararg iValidator: IValidator): Validate {
            iValidator.forEach {
                val res = it.validate()
                if (!res.status) return res
            }

            return Validate(true, "Successful".hashCode())
        }
    }
}