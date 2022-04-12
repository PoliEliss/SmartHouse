package com.rorono.smarthouse.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.rorono.smarthouse.R
import com.rorono.smarthouse.databinding.FragmentFloor1Binding
import com.rorono.smarthouse.databinding.FragmentTestBinding


class Test : Fragment() {


    lateinit var binding: FragmentTestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestBinding.inflate(layoutInflater)

        binding.test1.setOnClickListener { Navigation.findNavController(view!!).navigate(R.id.action_test_to_electro) }
        return binding.root
    }


}