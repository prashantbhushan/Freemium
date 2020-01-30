package com.prashant.freemiumnews.ui.newslist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.prashant.freemiumnews.ui.newslist.adapter.SliiderViewPagerAdapter
import com.prashant.freemiumnews.ui.newslist.model.Sliider
import kotlinx.android.synthetic.main.item_news_sliider.view.*

class NewsListSliiderViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(newsItem: Sliider) {
        itemView.viewPager.adapter = SliiderViewPagerAdapter(newsItem.images)
    }
}
