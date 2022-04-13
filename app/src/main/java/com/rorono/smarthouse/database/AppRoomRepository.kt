package com.rorono.smarthouse.database

import androidx.lifecycle.LiveData
import com.rorono.smarthouse.models.ElectricalAppliance

class AppRoomRepository(private val appRoomDao: AppRoomDao) : DatabaseRepository {
    override val allElectricalAppliance: LiveData<List<ElectricalAppliance>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(electricalAppliance: ElectricalAppliance, onSuccess: () -> Unit) {
        appRoomDao.insert(electricalAppliance)
    }

    override suspend fun delete(electricalAppliance: ElectricalAppliance, onSuccess: () -> Unit) {
        appRoomDao.delete(electricalAppliance)
    }


}