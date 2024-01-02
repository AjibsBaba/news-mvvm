package com.ajibsbaba.newsmvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajibsbaba.newsmvvm.data.NewsPost
import com.ajibsbaba.newsmvvm.data.NewsPostRepository
import kotlinx.coroutines.launch

class NewsPostViewModel: ViewModel() {
    private val repository = NewsPostRepository()

    private val _newsPosts = MutableLiveData<List<NewsPost>>()
    val newsPosts: LiveData<List<NewsPost>> = _newsPosts


    fun fetchNewsPosts() {
        viewModelScope.launch {
            try {
                val news = repository.getNewsPosts()
                _newsPosts.value = news
            } catch (e: Exception) {
                Log.d("Exception",e.message.toString())
            }
        }
    }
}