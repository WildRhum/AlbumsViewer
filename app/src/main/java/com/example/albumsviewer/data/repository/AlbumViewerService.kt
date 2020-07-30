package com.example.albumsviewer.data.repository

import com.example.albumsviewer.data.model.Album
import com.example.albumsviewer.data.model.Photo
import com.example.albumsviewer.data.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumViewerService {

    @GET("/users")
    suspend fun getUsers(): List<User>

    @GET("/albums")
    suspend fun getAlbums(): List<Album>

    @GET("/photos")
    suspend fun getPhotosFromAlbumId(@Query("albumId") albumId: Int): List<Photo>
}