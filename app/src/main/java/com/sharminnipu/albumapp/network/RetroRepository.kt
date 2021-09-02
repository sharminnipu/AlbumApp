package com.sharminnipu.albumapp.network

import androidx.lifecycle.MutableLiveData
import com.sharminnipu.albumapp.model.ImageData
import com.sharminnipu.albumapp.model.ImageModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroInstance: RetroServiceInstance) {

    fun makeApiCall(albumId: Int, liveDataList: MutableLiveData<ImageModel>) {
        val call: Call<ImageModel> = retroInstance.getDataFromAPI(albumId)
        call?.enqueue(object : Callback<ImageModel> {
            override fun onFailure(call: Call<ImageModel>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<ImageModel>, response: Response<ImageModel>) {
                liveDataList.postValue(response.body())
            }
        })

    }
}