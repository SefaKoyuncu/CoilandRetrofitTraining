package com.sefa.kotlinRickandMortyTraining.model

import com.google.gson.annotations.SerializedName


data class Location (

  @SerializedName("name" ) var name : String? = null,
  @SerializedName("url"  ) var url  : String? = null

)