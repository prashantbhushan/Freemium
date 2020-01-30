package com.prashant.freemiumnews.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prashant.freemiumnews.data.repository.NewsRepository
import com.prashant.freemiumnews.ui.newslist.NewsListViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val newsRepository: NewsRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(NewsListViewModel::class.java) -> return NewsListViewModel(
                newsRepository
            ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}