package com.rorono.smarthouse

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rorono.smarthouse.database.AppRoomDataBase
import com.rorono.smarthouse.database.AppRoomRepository
import com.rorono.smarthouse.utils.REPOSITORY
import java.lang.StringBuilder

class DataViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application
   // var allElectricalAppliance = REPOSITORY.allElectricalAppliance
    val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val message2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageOpen: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    var myLiveData = MyLiveData()


    fun initDataBase(string: String, onSuccess: () -> Unit) {
        if (string == "OK") {
            val dao = AppRoomDataBase.getInstance(mContext).getAppRoomDao()
            REPOSITORY = AppRoomRepository(dao)
            onSuccess()
        }
    }
}