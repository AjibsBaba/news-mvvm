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

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error


    fun fetchNewsPosts() {
        _isLoading.value = true

        viewModelScope.launch {
            try {
                val posts = repository.getNewsPosts()
                _newsPosts.value = posts
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("Exception",e.message.toString())
                _isLoading.value = false
            } finally {
                _isLoading.value = true
            }
        }
    }
}