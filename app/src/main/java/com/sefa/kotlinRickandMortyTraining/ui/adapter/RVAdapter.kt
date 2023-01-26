package com.sefa.kotlinRickandMortyTraining.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sefa.kotlinRickandMortyTraining.R
import com.sefa.kotlinRickandMortyTraining.model.Results

class RVAdapter(private val mContext:Context, private val charactersList:ArrayList<Results>)
    : RecyclerView.Adapter<RVAdapter.CardviewHolder>()
{
    inner class CardviewHolder(view:View):RecyclerView.ViewHolder(view)
    {
        var imageViewCharacter:ImageView
        var textViewName:TextView

        init {
            imageViewCharacter=view.findViewById(R.id.imageViewCharacter)
            textViewName=view.findViewById(R.id.textViewName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardviewHolder
    {
        val design=LayoutInflater.from(mContext)
            .inflate(R.layout.cardview_design,parent,false)

        return CardviewHolder(design)
    }

    override fun onBindViewHolder(holder: CardviewHolder, position: Int)
    {
        val character=charactersList[position]

        holder.textViewName.text=character.name
        holder.imageViewCharacter.load(character.image)
    }

    override fun getItemCount(): Int
    {
        return charactersList.size
    }


}