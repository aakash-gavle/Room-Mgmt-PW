package com.example.roommgmtpw.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roommgmtpw.model.Exclusion
import com.example.roommgmtpw.model.Facilities
import com.example.roommgmtpw.model.Facility
import com.example.roommgmtpw.model.Option
import com.example.roommgmtpw.network.RetroInstance
import com.example.roommgmtpw.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel :ViewModel() {
    private var recyclerListLiveData : MutableLiveData<Facilities> = MutableLiveData()

    fun getRecyclerListObserver(): MutableLiveData<Facilities> {
        return recyclerListLiveData
    }


    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response  = retroInstance.getFacilities()
            recyclerListLiveData.postValue(response)
        }
    }
}