package com.example.sampleimageloadapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleimageloadapp.data.Repository
import com.example.sampleimageloadapp.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initViews()
        fetchRandomPhotos()
    }

    private fun initViews(){

        binding.recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        binding.recyclerView.adapter = PhotoAdapter()


    }

    private fun fetchRandomPhotos(query : String? = null) =
        scope.launch{
            Repository.getRandomPhotos(query)?.let {photos ->

                (binding.recyclerView.adapter as? PhotoAdapter)?.apply {
                    this.photos = photos
                    notifyDataSetChanged()
                }
            }

    }



    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}