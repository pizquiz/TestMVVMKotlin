package com.guillesoft.testmvvmkotlin.viewmodel.login

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.guillesoft.testmvvmkotlin.`interface`.LoginResultCallBacks
import com.guillesoft.testmvvmkotlin.model.User

/**
 * 3:
 * @constructor LoginResultCallBacks
 * Se crea una variable listener con el constructor
 * Se extiende la clase desde ViewModel()
 * Se añade un Textwatcher para escuchar los campos
 *
 * Se implementa un metodo onLoginClicked para validar user.isDataValid()
 * este metodo sera llamado desde el xml
 */

class LoginViewModel(private val listener: LoginResultCallBacks) : ViewModel() {

    private val user: User = User("", "")

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                user.setEmail(p0.toString())
            }
        }

    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                user.setPassword(p0.toString())
            }
        }

    fun onLoginClicked(view: View) {
        when (val errorCode: Int = user.isDataValid()) {
            0 -> listener.onError("The email is empty!")
            1 -> listener.onError("The email is wrong!")
            2 -> listener.onError("The length of password is short!")
            -1 -> listener.onSuccess("Login Success!")
            else -> Log.e("LoginViewModel", "The errorCode is $errorCode")
        }
    }
}