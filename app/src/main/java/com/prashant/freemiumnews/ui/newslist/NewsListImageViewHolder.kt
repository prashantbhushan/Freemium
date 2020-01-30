package com.prashant.freemiumnews.ui.newslist

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prashant.freemiumnews.ui.newslist.model.ImageType
import kotlinx.android.synthetic.main.item_news_image_list.view.*

class NewsListImageViewHolder(
    itemView: View,
    val callBack: NewsImageItemClickListener
) : RecyclerView.ViewHolder(itemView) {

    fun bind(newsItem: ImageType) {
        itemView.rvImage.apply {
            layoutManager = GridLayoutManager(
                itemView.context, newsItem.images.size
            )
            adapter = NewsListImageAdapter(newsItem.images)
        }
        itemView.setOnClickListener {
            newsItem.deepLinkUrl?.let { callBack.onNewsImageItemClick(it) }
        }
    }
}

interface NewsImageItemClickListener {
    fun onNewsImageItemClick(deeplink: String)
}