package com.magnere.github.domain.repository

import com.magnere.github.domain.model.UserDetail
import com.magnere.github.domain.model.UserShort

interface UserRepository {
    suspend fun searchUser(name: String): List<UserShort>
    suspend fun getUserDetail(name: String): UserDetail
}