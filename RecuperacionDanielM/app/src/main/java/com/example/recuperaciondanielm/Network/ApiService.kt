package com.example.recuperaciondanielm.Network

import com.example.recuperaciondanielm.Models.Animals
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("animals")
    fun getAnimals(): Call<MutableList<Animals>>
}