package com.example.recuperaciondanielm.Repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.recuperaciondanielm.Common.Common
import com.example.recuperaciondanielm.Models.Animals
import com.example.recuperaciondanielm.Network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo {
    private val apiService: ApiService

    companion object {
        private const val TAG = "MainRepo"
    }

    init {
        apiService = Common.getApiService
    }

    val getAnimalModelLiveData: MutableLiveData<MutableList<Animals>>
    get() {
        val data: MutableLiveData<MutableList<Animals>> =
            MutableLiveData<MutableList<Animals>>()
        apiService.getAnimals().enqueue(object : Callback<MutableList<Animals>> {
            override fun onResponse(
                call: Call<MutableList<Animals>>,
                response: Response<MutableList<Animals>>
            ) {
                Log.e(TAG, "onResponse: " + response.code())
                if (response.isSuccessful){
                    data.value = response.body()
                }
                else{
                    data.value = null
                }
            }

            override fun onFailure(call: Call<MutableList<Animals>>, t: Throwable) {
                Log.e(TAG, "onResponse: " + t.message)
                data.value = null
            }
        })
        return data
    }
}
