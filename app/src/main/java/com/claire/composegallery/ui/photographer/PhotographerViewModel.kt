package com.claire.composegallery.ui.photographer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.claire.composegallery.data.model.Photographer
import com.claire.composegallery.data.model.photographer.Photos
import com.claire.composegallery.data.repo.AppRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotographerViewModel @Inject constructor(
    private val repo: AppRepo
): ViewModel() {

    private val _photographer = MutableLiveData<Photographer>()
    val photographer: LiveData<Photographer>
        get() = _photographer

    private val _photos = MutableLiveData<List<Photos>>()
    val photos: LiveData<List<Photos>>
        get() = _photos


    fun getPhotographer(name: String) = viewModelScope.launch {

        val result = repo.getPhotographer(name)

        result.onSuccess {
            println(it)
            _photographer.value = it
        }.onFailure {

        }
    }

    fun getPhotographerPhotos(name: String) = viewModelScope.launch {

        val result = repo.getPhotographerPhotos(name)

        result.onSuccess {
            println(it)
            _photos.value = it
        }.onFailure {

        }
    }
}