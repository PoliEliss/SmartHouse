package com.rorono.smarthouse

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.StringBuilder

open class DataViewModel : ViewModel() {
    val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val message2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageOpen:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    var myLiveData = MyLiveData()
}