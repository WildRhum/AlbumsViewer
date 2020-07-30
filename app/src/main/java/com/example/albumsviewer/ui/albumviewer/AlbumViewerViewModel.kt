package com.example.albumsviewer.ui.albumviewer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.albumsviewer.data.repository.AlbumViewerRepositoryImpl
import com.example.albumsviewer.data.repository.AlbumViewerRepositoryImpl.Companion.albumViewerRepositoryImpl
import kotlinx.coroutines.Dispatchers

class AlbumViewerViewModel : ViewModel() {

    private val repository: AlbumViewerRepositoryImpl = albumViewerRepositoryImpl

    val albums = liveData(Dispatchers.IO) {
        val retrievedData = repository.getAlbums().sortedBy { it.albumTitle }
        emit(retrievedData)
    }

    val users = liveData(Dispatchers.IO) {
        val retrievedData = repository.getUsers()
        emit(retrievedData)
    }
}