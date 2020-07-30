package com.example.albumsviewer.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    @SerializedName("id") var id : Int,
    @SerializedName ("albumId") var albumId : Int,
    @SerializedName ("thumbnailUrl") var photoUrl : String
) : Parcelable