package com.example.albumswiever.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.albumswiever.data.repository.AlbumViewerRepositoryImpl
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    private val repository: AlbumViewerRepositoryImpl = AlbumViewerRepositoryImpl()

    val albums = liveData(Dispatchers.Main) {
        val retrievedData = repository.getAlbums()
        emit(retrievedData)
    }

    val users = liveData(Dispatchers.IO) {
        val retrievedData = repository.getUsers()
        emit(retrievedData)
    }
}