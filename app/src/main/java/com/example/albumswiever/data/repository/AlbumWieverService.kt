package com.example.albumswiever.data.repository

import com.example.albumswiever.data.model.Album
import com.example.albumswiever.data.model.Photo
import com.example.albumswiever.data.model.User
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