package com.rorono.smarthouse.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rorono.smarthouse.DataViewModel
import com.rorono.smarthouse.ElectricalApplianceAdapter
import com.rorono.smarthouse.R
import com.rorono.smarthouse.TestModel
import com.rorono.smarthouse.databinding.FragmentElectroBinding
import com.rorono.smarthouse.models.ElectricalAppliance
import com.rorono.smarthouse.utils.REPOSITORY


class Electro : Fragment() {

      lateinit var viewModelTest:TestModel
    var adapter = ElectricalApplianceAdapter()
//private lateinit var recyclerView: RecyclerView
    val dataViewModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentElectroBinding
    lateinit var mObserverList: Observer<List<ElectricalAppliance>>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentElectroBinding.inflate(layoutInflater)



        binding.floatButtonAddElectricalAppliance.setOnClickListener {
            dataViewModel.initDataBase("OK") {
                Navigation.findNavController(view!!).navigate(R.id.action_electro_to_add)
            }

        }
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(view?.context)
            recyclerView.adapter = adapter
        }
        mObserverList = Observer {
            val list = it.asReversed()
           adapter.addElectroAppliance(list)
        }
        viewModelTest = ViewModelProvider(this).get(TestModel::class.java)
        viewModelTest.all.observe(this,mObserverList)
        //dataViewModel.allElectricalAppliance.observe(this,mObserverList)
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