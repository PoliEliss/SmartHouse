package com.rorono.smarthouse.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.ResourcesCompat.getColorStateList
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.rorono.smarthouse.DataViewModel
import com.rorono.smarthouse.MainActivity
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val appContext = context!!.applicationContext
        binding.switch11.isChecked = false
        binding.buttonTest.setOnClickListener {

            dataViewModel.myLiveData.setValueLivedata("Кипит")

        }
        dataViewModel.message2.observe(activity as LifecycleOwner, {

              binding.socet3.setBackgroundColor(ContextCompat.getColor(view.context,R.color.green))
              binding.socket.setBackgroundColor(ContextCompat.getColor(view.context,R.color.green))
              binding.socet2.setBackgroundColor(ContextCompat.getColor(view.context,R.color.green))
              binding.socket.text = it
              binding.switch11.isChecked = true

        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }
    companion object {

        fun newInstance() = Floor1()
    }
}





