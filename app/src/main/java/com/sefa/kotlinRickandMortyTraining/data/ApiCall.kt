package com.sefa.kotlinRickandMortyTraining.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiCall
{
    @GET("api/character")
    fun getCharacters() :Call<ResponseJSON>
}