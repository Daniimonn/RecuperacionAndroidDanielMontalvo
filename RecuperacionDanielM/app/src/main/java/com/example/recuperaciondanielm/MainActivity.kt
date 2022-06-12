package com.example.recuperaciondanielm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recuperaciondanielm.Adapter.AnimalAdapter
import com.example.recuperaciondanielm.Models.Animals
import com.example.recuperaciondanielm.ViewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    var mainActivityViewModel: MainActivityViewModel? = null
    var recyclerView: RecyclerView? = null
    var adapter: AnimalAdapter? = null
    var layoutManager: LinearLayoutManager? = null
    var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager

        mainActivityViewModel!!.getAnimalModel.observe(this) { animalModels ->
            Log.e("MainActivity", "AnimalList: " + animalModels.get(0).name)

            if (animalModels != null){
                adapter = AnimalAdapter(this, animalModels)
                adapter!!.notifyDataSetChanged()
                recyclerView!!.adapter = adapter
                dialog!!.dismiss()
            }
        }
    }
}