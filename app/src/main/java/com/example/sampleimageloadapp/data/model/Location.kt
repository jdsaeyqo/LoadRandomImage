package com.example.sampleimageloadapp.data.model


import com.google.gson.annotations.SerializedName

data class Location(
    val city: String?,
    val country: String?,
    val name: String?,
    val position: Position?
)