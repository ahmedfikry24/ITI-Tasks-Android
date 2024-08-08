package com.example.iti_tasks_android.ui.products.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iti_tasks_android.data.rest_full.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {

    private val api = RetrofitManager.service

    val state = MutableLiveData(listOf(ProductsState()))
    val isLoading = MutableLiveData(true)

    fun getProducts() {
        isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            val result = api.getProducts().body()?.map { it.toUiState() }
            state.postValue(result)
            isLoading.postValue(false)
        }
    }
}
