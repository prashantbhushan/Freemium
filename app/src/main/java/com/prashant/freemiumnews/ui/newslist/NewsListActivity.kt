package com.prashant.freemiumnews.ui.newslist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.prashant.freemiumnews.R
import com.prashant.freemiumnews.common.Result
import com.prashant.freemiumnews.common.ViewModelFactory
import com.prashant.freemiumnews.ui.newsdetail.NewsDetailActivity
import com.prashant.freemiumnews.ui.newslist.model.NewsItem
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_news_list.*
import javax.inject.Inject

class NewsListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var newsListViewModel: NewsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        newsListViewModel =
            ViewModelProviders.of(this, viewModelFactory)[NewsListViewModel::class.java]
        newsListViewModel.loadNewsList().observe(this, Observer {
            when (it?.status) {
                Result.SUCCESS -> {
                    hideLoadingIndicator()
                    handleNewsListResult(it.data)
                }
                Result.LOADING -> showLoadingIndicator()
                Result.ERROR -> {
                    hideLoadingIndicator()
                    showNewsListError(it.error)
                }
            }
        })
    }

    private fun showNewsListError(t: Throwable?) {
        t?.let { Snackbar.make(mainContainer, it.localizedMessage, Snackbar.LENGTH_LONG).show() }
    }

    private fun handleNewsListResult(data: List<NewsItem>?) {
        data?.let {
            with(rvNewsList) {
                addItemDecoration(
                    DividerItemDecoration(
                        applicationContext,
                        DividerItemDecoration.VERTICAL
                    )
                )
                layoutManager = LinearLayoutManager(NewsListActivity@ this.context)
                adapter = NewsListAdapter(it, object : NewsImageItemClickListener {
                    override fun onNewsImageItemClick(deeplink: String) {
                        handleNewsImageItemClick(deeplink)
                    }
                })
            }
        }
    }

    private fun showLoadingIndicator() {
        pbNewsList.visibility = View.VISIBLE
    }

    private fun hideLoadingIndicator() {
        pbNewsList.visibility = View.GONE
    }

    private fun handleNewsImageItemClick(deeplink: String) {
        startActivity(NewsDetailActivity.generateIntent(this, deeplink))
    }
}
