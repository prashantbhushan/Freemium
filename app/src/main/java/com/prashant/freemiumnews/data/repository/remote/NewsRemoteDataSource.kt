package com.prashant.freemiumnews.data.repository.remote

import com.prashant.freemiumnews.data.api.NewsApiService
import com.prashant.freemiumnews.data.model.NewsItemApi
import com.prashant.freemiumnews.data.repository.NewsDataSource
import io.reactivex.Single
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(val apiService: NewsApiService) : NewsDataSource {

    override fun loadNewsList(): Single<List<NewsItemApi>> {
        return apiService.getNews()
    }
}