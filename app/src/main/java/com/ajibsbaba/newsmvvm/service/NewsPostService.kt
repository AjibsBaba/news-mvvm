package com.ajibsbaba.newsmvvm.service

import com.ajibsbaba.newsmvvm.data.NewsPost
import retrofit2.http.GET

private const val apiKey = "b63ca3ed768e464f957b9d58392aed79"
interface NewsPostService {
    @GET("everything?q=tesla&from=2023-12-03&sortBy=publishedAt&apiKey=${apiKey}")
    suspend fun getNewsPosts(): List<NewsPost>
}