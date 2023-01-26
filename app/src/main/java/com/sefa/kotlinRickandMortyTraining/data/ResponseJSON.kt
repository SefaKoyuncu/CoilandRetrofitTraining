package com.sefa.kotlinRickandMortyTraining.data

import com.google.gson.annotations.SerializedName
import com.sefa.kotlinRickandMortyTraining.model.Info
import com.sefa.kotlinRickandMortyTraining.model.Results


data class ResponseJSON (

  @SerializedName("info"    ) var info    : Info?              = Info(),
  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf()

)