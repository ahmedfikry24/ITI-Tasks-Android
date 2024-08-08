package com.example.iti_tasks_android.data.rest_full

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {

    private val gson = GsonBuilder().create()
    private val gsonConverter = GsonConverterFactory.create(gson)

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(gsonConverter)
        .build()


    val service = retrofit.create(RetrofitServices::class.java)
}