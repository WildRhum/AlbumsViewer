package com.example.albumsviewer.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") var userId : Int,
    @SerializedName ("name") var userName : String
)