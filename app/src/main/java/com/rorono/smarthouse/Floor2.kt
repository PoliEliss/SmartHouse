package com.rorono.smarthouse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.rorono.smarthouse.databinding.FragmentFloor2Binding


class Floor2 : Fragment() {

    private val dataViewModel:DataViewModel by activityViewModels()
    lateinit var binding: FragmentFloor2Binding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFloor2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataViewModel.message.observe(activity as LifecycleOwner,{
            binding.tvMessage.text = it
        })

    }

    companion object {

        fun newInstance() = Floor2()
            }
    }
