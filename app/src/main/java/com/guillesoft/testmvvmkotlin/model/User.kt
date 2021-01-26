package com.guillesoft.testmvvmkotlin.model

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable

/**
 * 1:
 * Se crea un Modelo User con los parametros requeridos
 * @param email
 * @param password
 * Se extiende la clase desde BaseObservable()
 * Se implementan metodos get and set
 * Se implementa un metodo isDataValid() para validar la integridad de los datos
 */

data class User(private var email: String, private var password: String) : BaseObservable() {

    private fun getEmail(): String {
        return email
    }

    private fun getPassword(): String {
        return password
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun isDataValid(): Int {
        return if (TextUtils.isEmpty(getEmail())) {
            0
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            1
        } else if (getPassword().length < 4) {
            2
        } else {
            -1
        }
    }
}