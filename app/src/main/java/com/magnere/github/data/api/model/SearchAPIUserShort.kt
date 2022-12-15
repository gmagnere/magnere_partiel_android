package com.magnere.github.data.api.model

import com.google.gson.annotations.SerializedName

data class SearchAPIUserShort(

    val id: String,

    @SerializedName("login")
    val login: String,

    @SerializedName("avatar_url")
    val avatar_url: String

)
