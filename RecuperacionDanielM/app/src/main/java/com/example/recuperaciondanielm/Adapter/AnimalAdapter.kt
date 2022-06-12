package com.example.recuperaciondanielm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recuperaciondanielm.Models.Animals
import com.example.recuperaciondanielm.R
import com.squareup.picasso.Picasso

class AnimalAdapter(var context: Context, var animalModelList: MutableList<Animals>): RecyclerView.Adapter<AnimalAdapter.MyViewModel>(){
    inner class MyViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageAnimal: ImageView
        var txtAnimalName: TextView
        var txtTipoAnimal: TextView
        var txtBreed: TextView

        init {
            imageAnimal = itemView.findViewById(R.id.imageAnimal)
            txtAnimalName = itemView.findViewById(R.id.txtAnimalName)
            txtTipoAnimal = itemView.findViewById(R.id.txtTipoAnimal)
            txtBreed = itemView.findViewById(R.id.txtBreed)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        return MyViewModel(LayoutInflater.from(context).inflate(R.layout.layout_animals_list, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        Picasso.get().load(animalModelList[position].imageUrl).into(holder.imageAnimal)
        holder.txtAnimalName.text = animalModelList[position].name
        holder.txtTipoAnimal.text = animalModelList[position].kind
        holder.txtBreed.text = animalModelList[position].breed.toString()
    }

    override fun getItemCount(): Int {
        return animalModelList.size
    }

}