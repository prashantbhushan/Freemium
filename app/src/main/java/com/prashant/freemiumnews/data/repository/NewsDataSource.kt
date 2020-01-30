package com.prashant.freemiumnews.data.repository

import com.prashant.freemiumnews.data.model.NewsItemApi
import io.reactivex.Single

interface NewsDataSource {
    fun loadNewsList(): Single<List<NewsItemApi>>
}