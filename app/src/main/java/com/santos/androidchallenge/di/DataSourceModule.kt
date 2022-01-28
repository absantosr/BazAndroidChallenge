package com.santos.androidchallenge.di

import com.santos.androidchallenge.data.datasource.SongNetworkSourceImpl
import com.santos.androidchallenge.data.datasource.interfaces.SongNetworkSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun provideNetworkSongSource(songNetworkSourceImpl: SongNetworkSourceImpl):SongNetworkSource

}