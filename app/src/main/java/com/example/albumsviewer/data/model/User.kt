package com.example.albumsviewer.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("id") var userId : Int,
    @SerializedName ("name") var userName : String
) : Parcelable