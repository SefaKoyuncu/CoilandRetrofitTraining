package com.sefa.kotlinRickandMortyTraining.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCallService {

    private val BASE_URL="https://rickandmortyapi.com/"

    private val api=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiCall::class.java)

    fun call()= api.getCharacters()
}