package com.santos.androidchallenge.domain.repository

import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.domain.model.Lyrics
import com.santos.androidchallenge.domain.model.Summary

interface SongRepository {
    suspend fun fetchSong(term: String): ResultType<Summary, Failure>
    suspend fun getLyrics(artist: String, song: String): ResultType<Lyrics, Failure>
}