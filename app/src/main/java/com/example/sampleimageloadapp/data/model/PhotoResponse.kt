package com.example.sampleimageloadapp.data.model


import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    val blurHash: String?,
    val color: String?,
    val createdAt: String?,
    val currentUserCollections: List<Any>?,
    val description: String?,
    val downloads: Int?,
    val exif: Exif?,
    val height: Int?,
    val id: String?,
    val likedByUser: Boolean?,
    val likes: Int?,
    val links: Links?,
    val location: Location?,
    val updatedAt: String?,
    val urls: Urls?,
    val user: User?,
    val width: Int?
)