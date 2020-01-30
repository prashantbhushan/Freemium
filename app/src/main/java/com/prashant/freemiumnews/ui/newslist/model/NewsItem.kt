package com.prashant.freemiumnews.ui.newslist.model

import com.prashant.freemiumnews.data.model.ImageApi
import com.prashant.freemiumnews.data.model.NewsItemApi

sealed class NewsItem(val type: String?)

private const val TYPE_IMAGE = "image"
private const val TYPE_SLIIDER = "sliider"

data class Sliider(
    val datatype: String?,
    val images: List<Image>
) : NewsItem(datatype)

data class ImageType(
    val datatype: String?,
    val images: List<Image>,
    val deepLinkUrl: String?
) : NewsItem(datatype)

data class Image(
    var id: Int?,
    var url: String?
)

fun mapToDomain(newsItems: List<NewsItemApi>): List<NewsItem> {
    val newsList = arrayListOf<NewsItem>()
    for (news in newsItems) {
        when (news.type) {
            TYPE_IMAGE -> newsList.add(
                ImageType(
                    news.datatype,
                    mapImagesToDomain(news.images),
                    news.deepLinkUrl
                )
            )
            TYPE_SLIIDER -> newsList.add(
                Sliider(
                    news.datatype,
                    mapImagesToDomain(news.images)
                )
            )
        }
    }
    return newsList
}

fun mapImagesToDomain(images: List<ImageApi>): List<Image> {
    val imageList = arrayListOf<Image>()
    for (image in images) {
        imageList.add(Image(image.id, image.url))
    }
    return imageList
}