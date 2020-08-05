package com.example.albumsviewer.data.repository

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlbumViewerRepositoryImpl private constructor() : AlbumViewerRepository {

    private object HOLDER {
        val INSTANCE = AlbumViewerRepositoryImpl()
    }

    override suspend fun getAlbums() = retrofit.getAlbums()

    override suspend fun getUsers() = retrofit.getUsers()

    override suspend fun getPhotosWithAlbumId(albumId: Int) = retrofit.getPhotosFromAlbumId(albumId)

    companion object {
        val albumViewerRepository: AlbumViewerRepository by lazy { HOLDER.INSTANCE }

        private val BASE_URL = "https://jsonplaceholder.typicode.com"
        private val gson : Gson = GsonBuilder()
            .create()
        private val logging : HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BASIC)
        private val okHttpClient : OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logging)

        val retrofit: AlbumViewerService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient.build())
            .build().create(AlbumViewerService::class.java)
    }
}