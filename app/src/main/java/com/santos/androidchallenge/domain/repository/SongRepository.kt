package com.santos.androidchallenge.domain.repository

import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.domain.model.Song

interface SongRepository {
    suspend fun getSong(): ResultType<Song, Failure>
}