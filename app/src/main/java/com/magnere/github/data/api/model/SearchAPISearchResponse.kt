package com.magnere.github.data.api.model

import com.google.gson.annotations.SerializedName

data class SearchAPISearchResponse(
    @SerializedName("items")
    val users: List<SearchAPIUserShort>,
)


//{
//    "Search": [],
//    "totalResults": "4026",
//    "Response": "True"
//}