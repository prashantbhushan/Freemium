package com.prashant.freemiumnews.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prashant.freemiumnews.common.Result
import com.prashant.freemiumnews.ui.newslist.model.NewsItem
import com.prashant.freemiumnews.ui.newslist.model.mapToDomain
import com.prashant.freemiumnews.util.scheduler.RunOn
import com.prashant.freemiumnews.util.scheduler.SchedulerType
import io.reactivex.Scheduler
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val remoteDataSource: NewsDataSource,
    @RunOn(SchedulerType.IO) private val ioScheduler: Scheduler,
    @RunOn(SchedulerType.UI) private val uiScheduler: Scheduler
) {

    fun loadNewsList(): LiveData<Result<List<NewsItem>>> {
        val newsItem = MutableLiveData<Result<List<NewsItem>>>()
        remoteDataSource.loadNewsList()
            .observeOn(uiScheduler)
            .subscribeOn(ioScheduler)
            .doOnSubscribe({
                newsItem.value = Result.loading()
            })
            .subscribe({
                newsItem.value = Result.success(mapToDomain(it))
            }, {
                newsItem.value = Result.error(it)
            })
        return newsItem
    }
}