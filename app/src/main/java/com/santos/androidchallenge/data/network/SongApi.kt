package com.santos.androidchallenge.data.network

import com.santos.androidchallenge.data.entity.SongEntity
import retrofit2.Response
import retrofit2.http.GET

interface SongApi {

    @GET
    suspend fun fetchSong(): Response<SongEntity>
}