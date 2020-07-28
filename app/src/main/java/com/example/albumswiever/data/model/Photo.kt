package com.example.albumswiever.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    @SerializedName("id") var id : Int,
    @SerializedName ("albumId") var albumId : Int,
    @SerializedName ("url") var photoUrl : String
) : Parcelable