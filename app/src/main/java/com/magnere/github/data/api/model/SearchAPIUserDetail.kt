package com.magnere.github.data.api.model

import com.google.gson.annotations.SerializedName

data class SearchAPIUserDetail(
    val id: String,

    @SerializedName("login")
    val login: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("langage")
    val langage: String,

    @SerializedName("forks")
    val forks: String,

    @SerializedName("watchers")
    val watchers: String,

    @SerializedName("licence")
    val licence: String,

    @SerializedName("total_count")
    val number: String
)