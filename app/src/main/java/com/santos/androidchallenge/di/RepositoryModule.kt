package com.santos.androidchallenge.di

import com.santos.androidchallenge.data.repository.SongRepositoryImpl
import com.santos.androidchallenge.domain.repository.SongRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun provideSongRepository(songRepositoryImpl: SongRepositoryImpl): SongRepository
}