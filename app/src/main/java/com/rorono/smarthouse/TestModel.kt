package com.rorono.smarthouse

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.rorono.smarthouse.utils.REPOSITORY

class TestModel(application: Application):AndroidViewModel(application) {
    val all = REPOSITORY.allElectricalAppliance
}