package com.example.sampleimageloadapp

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
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
        bindViews()
        fetchRandomPhotos()
    }

    private fun initViews(){

        binding.recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        binding.recyclerView.adapter = PhotoAdapter()

    }

    @SuppressLint("ServiceCast")
    private fun bindViews(){
        binding.searchEditText.setOnEditorActionListener { editText , actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                currentFocus?.let {view ->

                    val inputMethodManager =
                        getSystemService(Context.INPUT_SERVICE) as? InputMethodManager
                    inputMethodManager?.hideSoftInputFromWindow(view.windowToken,0)

                    view.clearFocus()
                }

                fetchRandomPhotos(editText.text.toString())
            }

            true
        }

        binding.refreshLayout.setOnRefreshListener {
            fetchRandomPhotos(binding.searchEditText.text.toString())
        }
    }

    private fun fetchRandomPhotos(query : String? = null) =
        scope.launch{
            Repository.getRandomPhotos(query)?.let {photos ->

                (binding.recyclerView.adapter as? PhotoAdapter)?.apply {
                    this.photos = photos
                    notifyDataSetChanged()
                }

                binding.refreshLayout.isRefreshing = false
            }

    }



    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}