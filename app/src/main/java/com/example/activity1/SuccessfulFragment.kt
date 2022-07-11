package com.example.activity1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.activity1.databinding.FragmentsSuccessfulBinding


class SuccessfulFragment: Fragment() {
    private var bindingf : FragmentsSuccessfulBinding? = null
    private val binding get() = bindingf

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingf = FragmentsSuccessfulBinding.inflate(inflater, container, false)

        binding?.btnBack?.setOnClickListener{

            val firstFrag = com.example.activity1.LoginFragments()
            val transactions = fragmentManager?.beginTransaction()
            transactions?.replace(R.id.nav_host_fragment,firstFrag)?.commit()



        }





        return binding?.root

    }




}