package com.programmingninja.unittesting.helper


import org.junit.Test
import com.google.common.truth.Truth.assertThat

class RegisteringUtilityTest {
    @Test
    fun `empty first name return false`() {
        val res = RegisteringUtility.inputValidation(fName = "", lName = "Smith", uName = "AppleTini", pass = "123", pass2 = "123", terms = true)

        assertThat(res).isFalse()
    }

    @Test
    fun `empty last name return false`() {
        val res = RegisteringUtility.inputValidation(fName = "Bruce", lName = "", uName = "AppleTini", pass = "123", pass2 = "123", terms = true)

        assertThat(res).isFalse()
    }

    @Test
    fun `empty username return false`() {
        val res = RegisteringUtility.inputValidation(fName = "Bruce", lName = "Wayne", uName = "", pass = "123", pass2 = "123", terms = true)

        assertThat(res).isFalse()
    }

    @Test
    fun `empty password return false`() {
        val res = RegisteringUtility.inputValidation(fName = "Bruce", lName = "Wayne", uName = "MockingBird", pass = "", pass2 = "", terms = true)

        assertThat(res).isFalse()
    }

    @Test
    fun `terms not accepted return false`() {
        val res = RegisteringUtility.inputValidation(fName = "Bruce", lName = "Wayne", uName = "Pokemon", pass = "123", pass2 = "123", terms = false)

        assertThat(res).isFalse()
    }

    @Test
    fun `username already exists return false`() {
        val res = RegisteringUtility.inputValidation(fName = "David", lName = "Joe", uName = "kid_Flash123", pass = "75320@", pass2 = "75320@", terms = true )

        assertThat(res).isFalse()
    }

    @Test
    fun `password does not match return false`() {
        val res = RegisteringUtility.inputValidation(fName = "Wayne", lName = "Wayne", uName = "Batman", pass = "1000@", pass2 = "00001@", terms = true)

        assertThat(res).isFalse()
    }

    @Test
    fun `password is too short return false`() {
        val res = RegisteringUtility.inputValidation(fName = "Clark", lName = "Kent", uName = "Superman123", pass = "abc12@", pass2 = "abc12@", terms = true )

        assertThat(res).isFalse()
    }

    @Test
    fun `password is too long return false`() {
        val res = RegisteringUtility.inputValidation(fName = "Barry", lName = "Allen", uName = "drStrange", pass = "abcd1234xyz@", pass2 = "abcd1234xyz@", terms = false)

        assertThat(res).isFalse()
    }

    @Test
    fun `password doesnt have a special character return false`() {
        val res = RegisteringUtility.inputValidation(fName = "Dauris", lName = "Apple", uName="dApple", pass ="123abc12", pass2 = "123abc12",terms = true )
    }

    @Test
    fun `approved first name, last name, username, password and terms return false`() {
        val res = RegisteringUtility.inputValidation(fName = "Dauris", lName = "Apple", uName="dApple", pass ="123@abc", pass2 = "123@abc",terms = true )

        assertThat(res).isTrue()
    }




}