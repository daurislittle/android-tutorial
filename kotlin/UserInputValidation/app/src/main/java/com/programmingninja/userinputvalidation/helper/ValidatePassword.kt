package com.programmingninja.userinputvalidation.helper

import com.programmingninja.userinputvalidation.R
import com.programmingninja.userinputvalidation.helper.validator.BaseValidation
import com.programmingninja.userinputvalidation.helper.validator.Validate
import java.util.regex.Matcher
import java.util.regex.Pattern

class ValidatePassword(val pass: String) : BaseValidation() {

    val minLength = 6
    val maxLength = 32
    val specialPattern = Pattern.compile("[^a-zA-Z0-9]")
    val match: Matcher = specialPattern.matcher(pass)

    override fun validate(): Validate {
        if (pass.length < minLength) return Validate(false, R.string.txt_validation_pass_error_small)
        if (pass.length > maxLength) return  Validate(false, R.string.txt_validation_pass_error_long)
        if (!match.find()) return Validate(false, R.string.txt_validation_pass_error_special)

        return Validate(true, R.string.txt_validation_success)
    }
}