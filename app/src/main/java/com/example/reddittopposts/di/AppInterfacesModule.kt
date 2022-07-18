package com.example.reddittopposts.di

import com.example.reddittopposts.AppRepository
import com.example.reddittopposts.IAppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppInterfacesModule {

    // region Repository
    @Binds
    abstract fun bindRepository(impl: AppRepository): IAppRepository
}