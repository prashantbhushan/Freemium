package com.prashant.freemiumnews.ui.newslist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.prashant.freemiumnews.R
import com.prashant.freemiumnews.ui.newslist.model.Image
import com.squareup.picasso.Picasso


class SliiderViewPagerAdapter(val images: List<Image>) : PagerAdapter() {

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View = LayoutInflater.from(container.context)
            .inflate(R.layout.item_sliider_image, container, false)
        val imageView: ImageView = itemView.findViewById(R.id.imageView) as ImageView

        val image = images[position]
        Picasso.with(itemView.context).load(image.url).into(imageView);

        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        obj: Any
    ) {
        container.removeView(obj as LinearLayout)
    }
}