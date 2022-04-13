package com.rorono.smarthouse

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.rorono.smarthouse.database.AppRoomRepository
import com.rorono.smarthouse.models.ElectricalAppliance
import com.rorono.smarthouse.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewViewModel(application: Application) : AndroidViewModel(application) {

    fun insert(electricalAppliance: ElectricalAppliance, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {

            REPOSITORY.insert(electricalAppliance) {

                onSuccess()
            }
        }
}