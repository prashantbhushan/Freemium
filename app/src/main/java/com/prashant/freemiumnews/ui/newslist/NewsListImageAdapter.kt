package com.prashant.freemiumnews.ui.newslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.prashant.freemiumnews.R
import com.prashant.freemiumnews.ui.newslist.model.Image
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news_image.view.*

class NewsListImageAdapter(val images: List<Image>) :
    RecyclerView.Adapter<NewsListImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news_image, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val image = images[position]
        Picasso.with(holder.imageView.context).load(image.url).into(holder.imageView);
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.iv_news
    }
}