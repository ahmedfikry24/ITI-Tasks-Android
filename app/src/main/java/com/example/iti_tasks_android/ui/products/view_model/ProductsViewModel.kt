package com.example.iti_tasks_android.ui.products.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.iti_tasks_android.data.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsViewModelFactory(private val repository: RepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return modelClass.getConstructor(RepositoryImpl::class.java).newInstance(repository)
    }
}

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
