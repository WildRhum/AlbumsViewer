package com.example.albumsviewer.data.repository

import com.example.albumsviewer.data.model.Album
import com.example.albumsviewer.data.model.Photo
import com.example.albumsviewer.data.model.User

interface AlbumViewerRepository {
    suspend fun getAlbums() : List<Album>
    suspend fun getUsers() : List<User>
    suspend fun getPhotosWithAlbumId(albumId : Int) : List<Photo>
}