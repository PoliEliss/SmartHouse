package com.rorono.smarthouse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rorono.smarthouse.ElectricalApplianceAdapter.*
import com.rorono.smarthouse.databinding.ElectricalApplianceItemBinding
import com.rorono.smarthouse.databinding.FragmentAddBinding
import com.rorono.smarthouse.models.ElectricalAppliance

class ElectricalApplianceAdapter :
    RecyclerView.Adapter<ElectricalApplianceAdapter.ElectricalApplianceHolder>() {

    private var electricalApplianceList = mutableListOf<ElectricalAppliance>()

    inner class ElectricalApplianceHolder(binding: ElectricalApplianceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val etName = binding.tvItemElectricalAppliance
        private val etNumberSockte = binding.tvItemNumberSocket
        fun bind(electricalAppliance: ElectricalAppliance) {
            etName.text = electricalAppliance.title
            etNumberSockte.text = electricalAppliance.numberSocket

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectricalApplianceHolder {
        val binding = ElectricalApplianceItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ElectricalApplianceHolder(binding)
    }

    override fun onBindViewHolder(holder: ElectricalApplianceHolder, position: Int) {
        holder.bind(electricalApplianceList[position])
    }

    override fun getItemCount(): Int {
        return electricalApplianceList.size
    }

    fun addElectroAppliance(item: List<ElectricalAppliance>) {
        electricalApplianceList.apply {
            clear()
            addAll(item)

        }
        notifyDataSetChanged()
    }
}