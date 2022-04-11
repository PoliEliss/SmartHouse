package com.rorono.smarthouse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.rorono.smarthouse.databinding.FragmentElectroBinding


class Electro : Fragment() {

    private val dataViewModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentElectroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentElectroBinding.inflate(layoutInflater)
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