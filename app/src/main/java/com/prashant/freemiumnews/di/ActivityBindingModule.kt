package com.prashant.freemiumnews.di

import com.prashant.freemiumnews.ui.newslist.NewsListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {

    @ContributesAndroidInjector
    fun bindNewsListActivity(): NewsListActivity
}