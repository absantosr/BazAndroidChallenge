package com.santos.androidchallenge.di

import com.santos.androidchallenge.data.network.SongApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            //.addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    @Provides
    @Singleton
    fun provideCharactersApi(retrofit: Retrofit): SongApi =
        retrofit.create(SongApi::class.java)


    @Provides
    fun providesName(): String = "Albert"
}