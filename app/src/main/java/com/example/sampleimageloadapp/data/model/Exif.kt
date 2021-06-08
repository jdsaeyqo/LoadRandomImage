package com.example.sampleimageloadapp.data.model


import com.google.gson.annotations.SerializedName

data class Exif(

    val aperture: String?,

    val exposureTime: String?,

    val focalLength: String?,

    val iso: Int?,

    val make: String?,

    val model: String?
)