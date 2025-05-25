package com.irisaco.viewmodel_livedata

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val _counter = MutableLiveData<Int>(0)
    val counter : LiveData<Int> = _counter

    fun increaseCounter(view: View) {
        _counter.value = (_counter.value)?.plus(1)
    }

    fun getCounter(): Int {
        return counter.value?:0
    }
}