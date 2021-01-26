package com.guillesoft.testmvvmkotlin.viewmodel.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guillesoft.testmvvmkotlin.`interface`.LoginResultCallBacks

/**
 * 4:
 * @constructor LoginResultCallBacks
 * Se crea una variable listener con el constructor
 * Se extiende la clase desde ViewModelProvider.NewInstanceFactory()
 *
 * Se sobrescribe el metodo create y se retorna el LoginViewModel
 */

class LoginViewModelFactory(private val listener: LoginResultCallBacks) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}