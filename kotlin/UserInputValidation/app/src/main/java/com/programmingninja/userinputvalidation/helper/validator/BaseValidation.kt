package com.programmingninja.userinputvalidation.helper.validator

abstract class BaseValidation {
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