package com.rorono.smarthouse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.rorono.smarthouse.databinding.FragmentFloor1Binding

lateinit var test:String

class Floor1 : Fragment() {
    private val dataViewModel:DataViewModel by activityViewModels()
    lateinit var binding: FragmentFloor1Binding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentFloor1Binding.inflate(layoutInflater)
        return binding.root

    }

    private fun changeColorButton(str:String) {
            if (str=="1"){
                binding.socket.setBackgroundColor(resources.getColor(R.color.green))

            }
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

       binding.bSendToFloor2.setOnClickListener {
           dataViewModel.message.value = "Кукареку"

       }
        dataViewModel.message2.observe(activity as LifecycleOwner,{
            //binding.socket.text = it
            test = it
        })


        changeColorButton(test)

    }
    companion object {
        fun newInstance() = Floor1()
    }
}

