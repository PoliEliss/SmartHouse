package com.rorono.smarthouse.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.rorono.smarthouse.AddNewViewModel
import com.rorono.smarthouse.DataViewModel
import com.rorono.smarthouse.Menu
import com.rorono.smarthouse.R
import com.rorono.smarthouse.databinding.FragmentAddBinding
import com.rorono.smarthouse.databinding.FragmentFloor1Binding
import com.rorono.smarthouse.models.ElectricalAppliance
import com.rorono.smarthouse.utils.APP_MENU_ACTIVITY


class Add : Fragment() {

    private lateinit var mViewModel: AddNewViewModel

    //private val dataViewModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)

        binding.buttonAdd.setOnClickListener {
            Navigation.findNavController(view!!).navigate(R.id.action_add_to_electro)
        }
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        initialozation()
    }

    private fun initialozation() {
        mViewModel = ViewModelProvider(this).get(AddNewViewModel::class.java)
        binding.buttonAdd.setOnClickListener {
            val name = binding.editTextInputNameElectro.text.toString()
            val text = binding.editTextInputTextNote.text.toString()
            if (name.isEmpty()){
              Toast.makeText(activity,"Введите название прибора",Toast.LENGTH_SHORT).show()
            }else{

                mViewModel.insert(ElectricalAppliance(title = name, numberSocket = text)){


                    requireActivity().runOnUiThread {
                        Navigation.findNavController(view!!).navigate(R.id.action_add_to_electro)
                    }


                }
            }

        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = Add()
    }
}