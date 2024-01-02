package com.ajibsbaba.newsmvvm.data

import com.ajibsbaba.newsmvvm.service.RetrofitInstance

class NewsPostRepository {
    private val newsPostService = RetrofitInstance.newsPostService

    suspend fun getNewsPosts(): List<NewsPost> {
        return newsPostService.getNewsPosts()
    }
}