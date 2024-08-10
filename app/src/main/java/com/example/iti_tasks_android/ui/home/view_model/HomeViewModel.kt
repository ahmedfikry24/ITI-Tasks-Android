package com.example.iti_tasks_android.ui.home.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.iti_tasks_android.data.local.entity.InfoEntity
import com.example.iti_tasks_android.data.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return modelClass.getConstructor(Repository::class.java).newInstance(repository)
    }
}

class HomeViewModel(
    private val repository: Repository
) : ViewModel() {

    fun addInfo(phone: Int, message: String) {
        viewModelScope.launch {
            repository.addInfo(
                InfoEntity(
                    phone = phone,
                    message = message
                )
            )
        }
    }
}
