package com.santos.androidchallenge.data.datasource.interfaces

import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.data.entity.LyricsEntity
import com.santos.androidchallenge.data.entity.SongEntity

interface SongNetworkSource {

    suspend fun fetchSong(term: String): ResultType<List<SongEntity>, Failure>
    suspend fun getLyrics(artist: String, song: String): ResultType<LyricsEntity, Failure>
}