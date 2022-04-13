package com.rorono.smarthouse.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rorono.smarthouse.DataViewModel
import com.rorono.smarthouse.ElectricalApplianceAdapter
import com.rorono.smarthouse.R
import com.rorono.smarthouse.databinding.FragmentElectroBinding
import com.rorono.smarthouse.models.ElectricalAppliance


class Electro : Fragment() {

    var adapter = ElectricalApplianceAdapter()

    private val dataViewModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentElectroBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentElectroBinding.inflate(layoutInflater)



        binding.floatButtonAddElectricalAppliance.setOnClickListener {
            dataViewModel.initDataBase("OK"){
                Navigation.findNavController(view!!).navigate(R.id.action_electro_to_add)
            }

        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        dataViewModel.myLiveData.observe(this, Observer {
            binding.socet2.text = it

        })
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(view.context)
            recyclerView.adapter = adapter
        }
        addElectro()

    }

    companion object {


        @JvmStatic
        fun newInstance() = Electro()

    }

    fun addElectro() {
        val list: MutableList<ElectricalAppliance> = mutableListOf()
        list.add(ElectricalAppliance(1,"Чайник","2"))
        list.add(ElectricalAppliance(2,"Кондиционер","3"))
        list.add(ElectricalAppliance(3,"Робот","1"))
        adapter.addElectroAppliance(list)
    }

}