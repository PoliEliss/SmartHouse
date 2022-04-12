package com.rorono.smarthouse.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.rorono.smarthouse.DataViewModel
import com.rorono.smarthouse.R
import com.rorono.smarthouse.databinding.FragmentFloor1Binding


class Floor1 : Fragment() {
    private val dataViewModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentFloor1Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFloor1Binding.inflate(layoutInflater)
        return binding.root

    }

    private fun changeColorButton(str: String) {
        if (str == "1") {
            binding.socket.setBackgroundColor(resources.getColor(R.color.green))
            binding.socet2.setBackgroundColor(resources.getColor(R.color.green))
            binding.socet3.setBackgroundColor(resources.getColor(R.color.green))
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.buttonTest.setOnClickListener {

            dataViewModel.myLiveData.setValueLivedata("Кипит")

        }
        dataViewModel.message2.observe(activity as LifecycleOwner, {
            binding.socket.setBackgroundColor(resources.getColor(R.color.green))
            binding.socet2.setBackgroundColor(resources.getColor(R.color.green))
            binding.socet3.setBackgroundColor(resources.getColor(R.color.green))
            binding.socket.text = it


        })
    }



    companion object {
        fun newInstance() = Floor1()
    }
}

