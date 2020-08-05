package com.example.albumsviewer.ui.galeryviewer

import androidx.lifecycle.*
import com.example.albumsviewer.data.model.Album
import com.example.albumsviewer.data.repository.AlbumViewerRepository
import com.example.albumsviewer.data.repository.AlbumViewerRepositoryImpl.Companion.albumViewerRepository
import kotlinx.coroutines.Dispatchers

class GaleryViewerViewModel: ViewModel() {

    private val repository: AlbumViewerRepository = albumViewerRepository

    private val viewModelAlbum : MutableLiveData<Album> by lazy {
        MutableLiveData<Album>()
    }

    fun setAlbumData(album : Album){
        viewModelAlbum.value = album
    }

    fun getAlbum() : Album? {
        return viewModelAlbum.value
    }

    val photos = liveData(Dispatchers.IO) {
        val retrivedPhotos = viewModelAlbum.value?.albumId?.let { repository.getPhotosWithAlbumId(it) }
        emit(retrivedPhotos)
    }
}