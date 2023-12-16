package com.example.viewmodelroratemonitortest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    // live data
    val editTextValue : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}