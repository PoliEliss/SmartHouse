package com.rorono.smarthouse

import androidx.lifecycle.LiveData

class MyLiveData:LiveData<String>() {

    fun setValueLivedata(string: String){

        value = string

    }
}