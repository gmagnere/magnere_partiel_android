package com.magnere.github.presentation.directory

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.magnere.github.data.repository.SearchAPIUserRepository
import com.magnere.github.domain.model.UserDetail
import com.magnere.github.domain.repository.UserRepository
import kotlinx.coroutines.launch

class DirectoryViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository = SearchAPIUserRepository()

    private val _data = MutableLiveData<UserDetail>()
    val data: LiveData<UserDetail> get() = _data

    fun getUserDetail(movieId: String) {
        viewModelScope.launch {
            _data.value = userRepository.getUserDetail(movieId)
        }
    }

}