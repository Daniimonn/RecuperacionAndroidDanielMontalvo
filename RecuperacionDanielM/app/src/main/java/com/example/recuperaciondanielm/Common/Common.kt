package com.example.recuperaciondanielm.Common

import com.example.recuperaciondanielm.Network.ApiService
import com.example.recuperaciondanielm.Network.Retrofit
import retrofit2.create

object Common {
    private const val BASE_URL = "http://serveranimalutad-env.eba-zr9dsz3t.eu-west-3.elasticbeanstalk.com/"
    val getApiService: ApiService
    get() = Retrofit.getRetrofitClient(BASE_URL).create(ApiService::class.java)
}