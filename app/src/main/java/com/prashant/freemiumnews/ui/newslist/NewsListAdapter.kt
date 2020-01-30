package com.prashant.freemiumnews.ui.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prashant.freemiumnews.R
import com.prashant.freemiumnews.ui.newslist.model.ImageType
import com.prashant.freemiumnews.ui.newslist.model.NewsItem
import com.prashant.freemiumnews.ui.newslist.model.Sliider

private const val IMAGE_TYPE = 0
private const val SLIIDER_TYPE = 1

class NewsListAdapter(
    var newsItems: List<NewsItem>,
    val callBack: NewsImageItemClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(vg: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            IMAGE_TYPE -> NewsListImageViewHolder(
                LayoutInflater.from(vg.context).inflate(
                    R.layout.item_news_image_list,
                    vg,
                    false
                ),
                callBack
            )
            else -> NewsListSliiderViewHolder(
                LayoutInflater.from(vg.context).inflate(
                    R.layout.item_news_sliider,
                    vg,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (newsItems.get(position)) {
            is ImageType -> IMAGE_TYPE
            is Sliider -> SLIIDER_TYPE
        }
    }

    override fun onBindViewHolder(imageViewHolder: RecyclerView.ViewHolder, position: Int) {
        when (newsItems.get(position)) {
            is ImageType -> (imageViewHolder as NewsListImageViewHolder).bind(newsItems.get(position) as ImageType)
            is Sliider -> (imageViewHolder as NewsListSliiderViewHolder).bind(newsItems.get(position) as Sliider)
        }
    }
}