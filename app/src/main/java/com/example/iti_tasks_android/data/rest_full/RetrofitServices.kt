package com.example.iti_tasks_android.data.rest_full

import com.example.iti_tasks_android.data.models.ProductsDto
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {

    @GET("products")
    suspend fun getProducts(): Response<List<ProductsDto>>
}