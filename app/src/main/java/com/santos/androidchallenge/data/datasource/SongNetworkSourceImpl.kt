package com.santos.androidchallenge.data.datasource

import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.data.datasource.interfaces.SongNetworkSource
import com.santos.androidchallenge.data.entity.LyricsEntity
import com.santos.androidchallenge.data.entity.SummaryEntity
import com.santos.androidchallenge.data.network.SongApi
import javax.inject.Inject

class SongNetworkSourceImpl @Inject constructor(private val songApi: SongApi) : SongNetworkSource {

    override suspend fun fetchSong(term: String): ResultType<SummaryEntity, Failure> {
        val result = songApi.fetchSong(term)
        val body = result.body()
        return if (result.isSuccessful && body != null) {
            ResultType.Success(body)
        } else {
            ResultType.Error(Failure.ServerFailure)
        }
    }

    override suspend fun getLyrics(
        artist: String,
        song: String
    ): ResultType<LyricsEntity, Failure> {
        val result = songApi.getLyrics(artist, song)
        val body = result.body()
        return if (result.isSuccessful && body != null) {
            ResultType.Success(body)
        } else {
            ResultType.Error(Failure.ServerFailure)
        }
    }

}