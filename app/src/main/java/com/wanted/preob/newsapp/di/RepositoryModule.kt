package com.wanted.preob.newsapp.di

import com.wanted.preob.newsapp.data.remote.repository.RemoteRemoteNewsRepositoryImpl
import com.wanted.preob.newsapp.domain.repository.remote.RemoteNewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsNewsRepository(
        remoteNewsRepositoryImpl: RemoteRemoteNewsRepositoryImpl
    ): RemoteNewsRepository
}