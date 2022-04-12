package com.rorono.smarthouse.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.rorono.smarthouse.DataViewModel
import com.rorono.smarthouse.R
import com.rorono.smarthouse.databinding.FragmentElectroBinding
import com.rorono.smarthouse.databinding.FragmentTestBinding


class Electro : Fragment() {

    private val dataViewModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentElectroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentElectroBinding.inflate(layoutInflater)



        binding.floatButtonAddElectricalAppliance.setOnClickListener { Navigation.findNavController(view!!).navigate(R.id.action_electro_to_test) }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        dataViewModel.myLiveData.observe(this, Observer {
                binding.socet2.text = it

        })


    }
    companion object {


        @JvmStatic
        fun newInstance() = Electro()

    }
}