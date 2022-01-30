package com.santos.androidchallenge.data.network

import com.santos.androidchallenge.data.entity.LyricsEntity
import com.santos.androidchallenge.data.entity.SummaryEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SongApi {

    @GET("suggest/{search_term}")
    suspend fun fetchSong(@Path("search_term") term: String): Response<SummaryEntity>

    @GET("/v1/{artist}/{song}")
    suspend fun getLyrics(
        @Path("artist") artist: String,
        @Path("song") song: String
    ): Response<LyricsEntity>
}