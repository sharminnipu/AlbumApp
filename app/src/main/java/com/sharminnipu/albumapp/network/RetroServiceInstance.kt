package com.sharminnipu.albumapp.network

import android.media.Image
import com.sharminnipu.albumapp.model.ImageData
import com.sharminnipu.albumapp.model.ImageModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInstance {
    @GET("photos")
    fun getDataFromAPI(
        @Query("albumId")albumId: Int):Call<ImageModel>
}