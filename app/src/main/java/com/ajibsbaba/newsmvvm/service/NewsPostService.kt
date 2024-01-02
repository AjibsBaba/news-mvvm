package com.ajibsbaba.newsmvvm.service

import com.ajibsbaba.newsmvvm.data.NewsPost
import retrofit2.http.GET

interface NewsPostService {
    @GET("everything")
    suspend fun getNewsPosts(): List<NewsPost>
}