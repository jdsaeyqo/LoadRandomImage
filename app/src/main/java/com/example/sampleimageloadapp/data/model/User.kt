package com.example.sampleimageloadapp.data.model


import com.google.gson.annotations.SerializedName

data class User(
    val bio: String?,
    val id: String?,
    val instagramUsername: String?,
    val links: LinksX?,
    val location: String?,
    val name: String?,
    val portfolioUrl: String?,
    val totalCollections: Int?,
    val totalLikes: Int?,
    val totalPhotos: Int?,
    val twitterUsername: String?,
    val updatedAt: String?,
    val username: String?
)