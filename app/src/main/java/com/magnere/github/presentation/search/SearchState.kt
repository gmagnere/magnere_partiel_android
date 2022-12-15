package com.magnere.github.presentation.search

import com.magnere.github.domain.model.UserShort

sealed class SearchState {

    class Success(val userShort: List<UserShort>) : SearchState()

    object Loading : SearchState()

    object Error : SearchState()

}