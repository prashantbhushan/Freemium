package com.prashant.freemiumnews.ui.newslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.prashant.freemiumnews.common.Result
import com.prashant.freemiumnews.data.repository.NewsRepository
import com.prashant.freemiumnews.ui.newslist.model.NewsItem

class NewsListViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    fun loadNewsList(): LiveData<Result<List<NewsItem>>> {
        return newsRepository.loadNewsList()
    }
}