package com.example.iti_tasks_android.data.remote

import com.example.iti_tasks_android.data.models.ProductDto
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {

    @GET("products")
    suspend fun getProducts(): Response<List<ProductDto>>
}