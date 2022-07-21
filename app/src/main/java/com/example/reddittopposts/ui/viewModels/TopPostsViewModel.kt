package com.example.reddittopposts.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.reddittopposts.entities.PostModel
import com.example.reddittopposts.repositories.ITopPostsRepository
import com.example.reddittopposts.usecases.ITopPostsUseCase
import com.example.reddittopposts.usecases.TopPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopPostsViewModel @Inject constructor(
    private val topPostsUseCase: ITopPostsUseCase,
    private val repository: ITopPostsRepository
) : ViewModel() {


    var news: Flow<PagingData<PostModel>>? = null

    // val posts: StateFlow<PagingData<PostModel>>
    fun getData() : Flow<PagingData<PostModel>> {
        if (news == null) {
            news = topPostsUseCase.getRedditData().cachedIn(viewModelScope)


        }
        return news as Flow<PagingData<PostModel>>
    }

}