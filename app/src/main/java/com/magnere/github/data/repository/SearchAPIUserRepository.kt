package com.magnere.github.data.repository

import com.magnere.github.data.api.SearchApi
import com.magnere.github.data.api.model.SearchAPIUserDetail
import com.magnere.github.data.api.model.SearchAPIUserShort
import com.magnere.github.domain.model.UserDetail
import com.magnere.github.domain.model.UserShort
import com.magnere.github.domain.repository.UserRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchAPIUserRepository : UserRepository {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(SearchApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(SearchApi::class.java)

    override suspend fun searchUser(name: String): List<UserShort> {
        return api.searchUser(name).users.map {
            it.toUserShort()
        }
    }

    override suspend fun getUserDetail(name: String): UserDetail {
        return api.getUserDetail(name).toUserDetail()
    }
}

private fun SearchAPIUserShort.toUserShort() =
    UserShort(
        this.id,
        this.login,
        this.avatar_url
    )

private fun SearchAPIUserDetail.toUserDetail() =
    UserDetail(
        this.id,
        this.login,
        this.description,
        this.langage,
        this.forks,
        this.watchers,
        this.licence,
        this.number,
    )