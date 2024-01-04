package com.ajibsbaba.newsmvvm.service

import com.ajibsbaba.newsmvvm.data.NewsPost
import com.ajibsbaba.newsmvvm.service.RetrofitInstance.API_KEY
import retrofit2.http.GET

interface NewsPostService {
    @GET("everything?q=tesla&from=2023-12-03&sortBy=publishedAt&apiKey=${API_KEY}")
    suspend fun getNewsPosts(): List<NewsPost>
}