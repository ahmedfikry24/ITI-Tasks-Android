package com.example.iti_tasks_android.ui.gallery.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.iti_tasks_android.data.local.entity.InfoEntity
import com.example.iti_tasks_android.data.repository.Repository
import kotlinx.coroutines.launch

class GalleryViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return modelClass.getConstructor(Repository::class.java).newInstance(repository)
    }
}

class GalleryViewModel(
    private val repository: Repository,
) : ViewModel() {
    val info = MutableLiveData<List<InfoEntity>>(listOf())

    fun getInfo() {
        viewModelScope.launch {
            val info = repository.getInfo()
            this@GalleryViewModel.info.postValue(info)
        }
    }

    fun deleteInfo() {
        viewModelScope.launch {
            repository.deleteInfo()
            repository.getInfo()
        }
    }
}
