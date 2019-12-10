package com.example.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    // val _count refer to mutableLiveData
    // Mutable means can change
    // Live data will go through certain life cycle
    // Reference variable - pointer
    private val _count = MutableLiveData<Int>()

    // Create getter and setter
    val count : LiveData<Int>
        get() = _count // getter of _count

    fun increment() {
        // _count.value? is current value
        _count.value = _count.value?.plus(1)
    }

    fun decrement() {
        // _count.value? is current value
        _count.value = _count.value?.minus(1)
    }

    // It will initialised automatically (1 time only) when create instance of viewModel
    init {
        Log.d("MainActivity", "ViewModel initialised")
        _count.value = 0
    }

    override fun onCleared() {
        Log.d("MainActivity", "ViewModel cleared")
        super.onCleared()
    }
}