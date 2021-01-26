package com.guillesoft.testmvvmkotlin.`interface`

/**
 * 2:
 * Se crea esta interface con los metodos para
 * evaluar exito u error
 */

interface LoginResultCallBacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}