package com.example.reddittopposts.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reddittopposts.IAppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopPostsViewModel @Inject constructor(
    private val repository: IAppRepository
) : ViewModel() {

    fun getData() {
        viewModelScope.launch {
            repository.getRedditPosts()
        }
    }
}