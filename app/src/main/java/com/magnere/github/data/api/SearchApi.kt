package com.magnere.github.data.api

import com.magnere.github.data.api.model.SearchAPISearchResponse
import com.magnere.github.data.api.model.SearchAPIUserDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    companion object {
        const val BASE_URL = " https://api.github.com"
    }

    // https://api.github.com/search/users?q={name}

    @GET("/search/users")
    suspend fun searchUser(
        @Query("q") name: String
    ): SearchAPISearchResponse

    //https://api.github.com/users/{name}/repos

    @GET("users/")
    suspend fun getUserDetail(
        @Query("name") name: String
    ): SearchAPIUserDetail

}