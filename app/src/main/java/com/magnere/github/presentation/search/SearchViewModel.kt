package com.magnere.github.presentation.search

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.magnere.github.data.repository.SearchAPIUserRepository
import com.magnere.github.domain.repository.UserRepository
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository = SearchAPIUserRepository()

    private val _state = MutableLiveData<SearchState>()

    val state: LiveData<SearchState> get() = _state

    fun searchUser(text: String) {
        _state.value = SearchState.Loading

        viewModelScope.launch {
            try {
                _state.value = SearchState.Success(userRepository.searchUser(text))
            } catch (e: Exception) {
                Log.e("BUG", "Exception $e")
                _state.value = SearchState.Error
            }
        }

    }

}