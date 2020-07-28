package com.example.albumswiever.data.repository

import com.example.albumswiever.data.model.Album
import com.example.albumswiever.data.model.Photo
import com.example.albumswiever.data.model.User

interface AlbumViewerRepository {
    suspend fun getAlbums() : List<Album>
    suspend fun getUsers() : List<User>
    suspend fun getPhotoWithAlbumId(albumId : Int) : List<Photo>
}