package com.example.iti_tasks_android.ui.products.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iti_tasks_android.data.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val repository: RepositoryImpl
) : ViewModel() {

    val events = MutableLiveData<ProductsEvents>(ProductsEvents.Idle)
    val state = MutableLiveData(listOf(ProductsState()))
    val isLoading = MutableLiveData(true)

    fun getProducts() {
        isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getAllProducts().map {
                it.toUiState(
                    onItemClick = {
                        events.postValue(
                            ProductsEvents.NavigateToProductDetails(
                                title = it.title ?: "",
                                description = it.description ?: "",
                                imageUrl = it.image ?: ""
                            )
                        )
                    }
                )
            }
            state.postValue(result)
            isLoading.postValue(false)
        }
    }
}
