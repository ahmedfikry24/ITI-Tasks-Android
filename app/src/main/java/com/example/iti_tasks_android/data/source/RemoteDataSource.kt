package com.example.iti_tasks_android.data.source

import com.example.iti_tasks_android.data.models.ProductDto
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getAllProducts(): Response<List<ProductDto>>
}