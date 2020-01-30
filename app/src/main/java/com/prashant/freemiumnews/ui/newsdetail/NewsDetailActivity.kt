package com.prashant.freemiumnews.ui.newsdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prashant.freemiumnews.R
import kotlinx.android.synthetic.main.activity_news_detail.*

private const val DEEPLIK_URL = "deeplink_url"

class NewsDetailActivity : AppCompatActivity() {

    companion object {
        fun generateIntent(
            context: Context,
            deeplink: String
        ) = Intent(context, NewsDetailActivity::class.java).apply {
            putExtra(DEEPLIK_URL, deeplink)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        webview.loadUrl(intent.getStringExtra(DEEPLIK_URL))
    }
}
