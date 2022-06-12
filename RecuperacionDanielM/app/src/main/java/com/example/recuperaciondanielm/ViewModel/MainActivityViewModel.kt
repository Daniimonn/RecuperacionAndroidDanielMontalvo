package com.example.recuperaciondanielm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.recuperaciondanielm.Models.Animals
import com.example.recuperaciondanielm.Repositories.MainRepo

class MainActivityViewModel : ViewModel() {
    private val mainRepo: MainRepo
    val getAnimalModel: LiveData<MutableList<Animals>>
        get() = mainRepo.getAnimalModelLiveData

    init {
        mainRepo = MainRepo()
    }
}