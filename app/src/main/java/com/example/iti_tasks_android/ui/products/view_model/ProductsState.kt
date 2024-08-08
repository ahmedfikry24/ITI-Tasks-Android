package com.example.iti_tasks_android.ui.products.view_model

import com.example.iti_tasks_android.data.models.ProductsDto

data class ProductsState(
    val title: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val imageUrl: String = ""
)

fun ProductsDto.toUiState(): ProductsState {
    return ProductsState(
        title = this.title ?: "",
        description = this.description ?: "",
        price = this.price ?: 0.0,
        imageUrl = this.image ?: ""
    )
}
