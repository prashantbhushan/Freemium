package com.prashant.freemiumnews.data.model

import com.google.gson.annotations.SerializedName

class NewsItemApi(
    val type: String?,
    val datatype: String?,
    val images: List<ImageApi>,
    @SerializedName("deep_link") val deepLinkUrl: String
)

data class ImageApi(
    var id: Int,
    var url: String
)