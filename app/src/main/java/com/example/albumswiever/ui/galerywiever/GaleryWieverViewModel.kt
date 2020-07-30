package com.example.albumswiever.ui.galerywiever

import androidx.lifecycle.*
import com.example.albumswiever.data.model.Album
import com.example.albumswiever.data.repository.AlbumViewerRepositoryImpl
import com.example.albumswiever.data.repository.AlbumViewerRepositoryImpl.Companion.albumViewerRepositoryImpl
import kotlinx.coroutines.Dispatchers

class GaleryWieverViewModel: ViewModel() {

    private val repository: AlbumViewerRepositoryImpl = albumViewerRepositoryImpl

    private val viewModelAlbum : MutableLiveData<Album> by lazy {
        MutableLiveData<Album>()
    }

    fun setAlbumData(album : Album){
        viewModelAlbum.value = album
    }

    val photos = liveData(Dispatchers.IO) {
        val retrivedPhotos = viewModelAlbum.value?.albumId?.let { repository.getPhotosWithAlbumId(it) }
        emit(retrivedPhotos)
    }
}