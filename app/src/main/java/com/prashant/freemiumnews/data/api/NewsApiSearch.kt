package com.prashant.freemiumnews.data.api

import com.prashant.freemiumnews.data.model.NewsItemApi
import io.reactivex.Single
import retrofit2.http.GET

interface NewsApiService {
    @GET("feed")
    fun getNews(): Single<List<NewsItemApi>>
}