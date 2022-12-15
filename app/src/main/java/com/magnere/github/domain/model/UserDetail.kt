package com.magnere.github.domain.model

data class UserDetail(
    val id: String,
    val login: String,
    val description: String,
    val langage: String,
    val forks: String,
    val watchers: String,
    val licence: String,
    val total_count: String,
)