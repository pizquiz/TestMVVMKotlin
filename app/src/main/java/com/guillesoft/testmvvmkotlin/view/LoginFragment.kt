package com.guillesoft.testmvvmkotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.guillesoft.testmvvmkotlin.R
import com.guillesoft.testmvvmkotlin.`interface`.LoginResultCallBacks
import com.guillesoft.testmvvmkotlin.databinding.FragmentLoginBinding
import com.guillesoft.testmvvmkotlin.viewmodel.login.LoginViewModel
import com.guillesoft.testmvvmkotlin.viewmodel.login.LoginViewModelFactory
import es.dmoral.toasty.Toasty

/**
 * 6:
 * Se extiende la clase desde LoginResultCallBacks
 * Se implementan metodos
 * Se cambia la forma en que se infla la vista
 * se cambia de binding a DataBindingUtil
 */

class LoginFragment : Fragment(), LoginResultCallBacks {

    //private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var loginActivityBinding = activity?.let { DataBindingUtil.setContentView<FragmentLoginBinding>(it, R.layout.fragment_login) }
        loginActivityBinding?.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this)).get(LoginViewModel::class.java)
        return inflater.inflate(R.layout.fragment_login, container, false)
        //binding = FragmentLoginBinding.inflate(inflater, container, false)
        //return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding?.btnLogin?.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.principalFragment)
        }*/
    }

    override fun onSuccess(message: String) {
        context?.let { Toasty.success(it, message, Toast.LENGTH_SHORT, true).show() }
    }

    override fun onError(message: String) {
        context?.let { Toasty.error(it, message, Toast.LENGTH_SHORT, true).show() }
    }
}