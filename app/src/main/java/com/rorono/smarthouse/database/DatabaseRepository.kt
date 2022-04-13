package com.rorono.smarthouse.database

import androidx.lifecycle.LiveData
import com.rorono.smarthouse.models.ElectricalAppliance

interface DatabaseRepository {

    val allElectricalAppliance: LiveData<List<ElectricalAppliance>>
    suspend fun insert(electricalAppliance: ElectricalAppliance, onSuccess: () -> Unit)
    suspend fun delete(electricalAppliance: ElectricalAppliance, onSuccess: () -> Unit)
}