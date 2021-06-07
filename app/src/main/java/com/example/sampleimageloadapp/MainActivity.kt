package com.example.sampleimageloadapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleimageloadapp.data.Repository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchRandomPhotos()
    }

    private fun fetchRandomPhotos(query : String? = null) =
        scope.launch{
            Repository.getRandomPhotos(query)?.let {photos ->

                photos
            }

    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}