package com.sharminnipu.albumapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sharminnipu.albumapp.di.AppModule
import com.sharminnipu.albumapp.model.ImageData
import com.sharminnipu.albumapp.model.ImageModel
import com.sharminnipu.albumapp.network.RetroRepository

import com.sharminnipu.albumapp.network.RetroServiceInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetroRepository): ViewModel() {
    lateinit var liveDataList: MutableLiveData<ImageModel>
    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<ImageModel>{
        return liveDataList
    }

    fun loadListOfData(album:Int) {
        repository.makeApiCall(album, liveDataList)
    }
}
