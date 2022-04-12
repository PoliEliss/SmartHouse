package com.rorono.smarthouse.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.rorono.smarthouse.DataViewModel
import com.rorono.smarthouse.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    private val dataViewModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.openAll.setOnClickListener {
            dataViewModel.message2.value = "2"
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = MenuFragment()
    }

    override fun onStart() {
        super.onStart()
    }
}
