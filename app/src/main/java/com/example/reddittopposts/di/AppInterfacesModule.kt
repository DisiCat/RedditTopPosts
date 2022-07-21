package com.example.reddittopposts.di

import com.example.reddittopposts.repositories.TopPostsRepository
import com.example.reddittopposts.repositories.ITopPostsRepository
import com.example.reddittopposts.usecases.ITopPostsUseCase
import com.example.reddittopposts.usecases.TopPostsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppInterfacesModule {

    // region Repository
    @Binds
    abstract fun bindRepository(impl: TopPostsRepository): ITopPostsRepository

    // region UseCase
    @Binds
    abstract fun bindTopPostsUseCase(impl: TopPostsUseCase): ITopPostsUseCase
}