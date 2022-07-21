package com.example.reddittopposts.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.reddittopposts.entities.PostModel
import com.example.reddittopposts.usecases.ITopPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TopPostsViewModel @Inject constructor(
    topPostsUseCase: ITopPostsUseCase,
) : ViewModel() {
    var topPosts: Flow<PagingData<PostModel>>? =
        topPostsUseCase.getRedditData().cachedIn(viewModelScope)
}