package com.santos.androidchallenge.domain.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Lyrics(
    val lyrics: String
) : Parcelable