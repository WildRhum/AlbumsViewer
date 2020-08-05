package com.example.albumsviewer.ui.albumviewer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.albumsviewer.data.repository.AlbumViewerRepository
import com.example.albumsviewer.data.repository.AlbumViewerRepositoryImpl.Companion.albumViewerRepository
import kotlinx.coroutines.Dispatchers

class AlbumViewerViewModel : ViewModel() {

    private val repository: AlbumViewerRepository = albumViewerRepository

    val albums = liveData(Dispatchers.IO) {
        val retrievedData = repository.getAlbums().sortedBy { it.albumTitle }
        emit(retrievedData)
    }

    val users = liveData(Dispatchers.IO) {
        val retrievedData = repository.getUsers()
        emit(retrievedData)
    }
}