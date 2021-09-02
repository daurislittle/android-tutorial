package com.programmingninja.textinputlayoutvallidation.helper

import java.util.regex.Pattern

object ValidateFormat {
    val EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+")
    val PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]*\$")

    /**
     * confirm email formatted correctly
     */
    fun validEmailFormat(email: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }

    fun validPasswordFormat(pwd: String): Boolean {
        return PASSWORD_PATTERN.matcher(pwd).matches()
    }

    fun validStringFormat(name: String): Boolean {

        if (name.length >= 5 ) {
            return true
        }
        return false

    }
}