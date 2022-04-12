package com.rorono.smarthouse.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.rorono.smarthouse.DataViewModel
import com.rorono.smarthouse.R
import com.rorono.smarthouse.databinding.FragmentAddBinding
import com.rorono.smarthouse.databinding.FragmentFloor1Binding


class Add : Fragment() {

    private val dataViewModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)

        binding.buttonAdd.setOnClickListener {
            Navigation.findNavController(view!!).navigate(R.id.action_add_to_electro) }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = Add()
    }
}