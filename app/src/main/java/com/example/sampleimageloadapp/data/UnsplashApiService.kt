package com.example.sampleimageloadapp.data

import com.example.sampleimageloadapp.BuildConfig
import com.example.sampleimageloadapp.data.model.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApiService {

    @GET(
        "photos/random?" +
                "client_id=${BuildConfig.UNSPLASH_ACCESS_KEY}"+
                "&count=30"
    )
    suspend fun getRandomPhotos(
        @Query("query") query : String?
    ): Response<List<PhotoResponse>>



}