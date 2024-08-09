package com.example.iti_tasks_android.ui.products.view_model

sealed class ProductsEvents {
    data object Idle : ProductsEvents()
    data class NavigateToProductDetails(
        val title: String,
        val description: String,
        val imageUrl: String
    ) : ProductsEvents()
}
