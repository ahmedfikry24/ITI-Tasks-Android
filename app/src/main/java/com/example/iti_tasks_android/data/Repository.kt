package com.example.iti_tasks_android.data

import com.example.iti_tasks_android.data.models.ProductDto

interface Repository {

    suspend fun getAllProducts(): List<ProductDto>
}