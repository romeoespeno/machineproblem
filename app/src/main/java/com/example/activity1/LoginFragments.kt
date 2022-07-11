package com.example.activity1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.activity1.databinding.FragmentsLoginBinding
import com.google.android.material.textfield.TextInputLayout


class LoginFragments: Fragment(R.layout.fragments_login), FragmentsCallBack {

    private var bindingf :FragmentsLoginBinding? = null
    private val binding get() = bindingf


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingf = FragmentsLoginBinding.inflate(inflater, container, false)

        binding?.elEmailAddress?.addOnEditTextAttachedListener(object: TextWatcher,
            TextInputLayout.OnEditTextAttachedListener {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(!Patterns.EMAIL_ADDRESS.matcher(binding?.elEmailAddress.toString()).matches()){
                    binding?.btnLogin?.isEnabled = false
                    binding?.btnLogin?.error = "Invalid Email Address"
                }else{
                    binding?.btnLogin?.isEnabled = true
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

            override fun onEditTextAttached(textInputLayout: TextInputLayout) {

            }

        })

        binding?.elPassword?.addOnEditTextAttachedListener(object: TextWatcher,
            TextInputLayout.OnEditTextAttachedListener {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(s?.count()!! < 13 ){
                    return onError("Must contain 13 characters")
                }else{
                    binding?.btnLogin?.isEnabled = true

                }
                if(!s.toString().matches(".*[A-Z].*".toRegex())){
                    return onError("Must contain Uppercase")
                }else{
                    binding?.btnLogin?.isEnabled = true

                }
                if(!s.toString().matches(".*[a-z].*".toRegex())){
                    return onError("Must contain lowercase")
                }else{
                    binding?.btnLogin?.isEnabled = true

                }

                if(!s.toString().matches(".*[@#$%!^&*()+_=].*".toRegex())){
                    return onError("Must contain special character")
                }
                else{
                    binding?.btnLogin?.isEnabled = true
                }


            }

            override fun afterTextChanged(s: Editable?) {

            }

            override fun onEditTextAttached(textInputLayout: TextInputLayout) {

            }

        })

        binding?.btnLogin?.setOnClickListener{

//            val secondFragments = com.example.activity1.SuccessfulFragment()
//            val transactions = fragmentManager?.beginTransaction()
//            transactions?.replace(R.id.nav_host_fragment,secondFragments)?.commit()

            val username = binding?.elEmailAddress?.toString()?.trim()
            val pass = binding?.elPassword?.toString()?.trim()


//            if(username?.isEmpty()!!)

        }


        return binding?.root
    }

    override fun onSuccess(message: String) {

    }

    override fun onError(message: String) {
    }

}


