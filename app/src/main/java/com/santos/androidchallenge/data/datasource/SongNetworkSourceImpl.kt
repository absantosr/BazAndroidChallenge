package com.santos.androidchallenge.data.datasource

import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.data.datasource.interfaces.SongNetworkSource
import com.santos.androidchallenge.data.entity.SongEntity
import com.santos.androidchallenge.data.network.SongApi
import javax.inject.Inject

class SongNetworkSourceImpl @Inject constructor(private val songApi: SongApi) : SongNetworkSource {
    override suspend fun getSong(): ResultType<SongEntity, Failure> {
        val result = songApi.fetchSong()
        val body = result.body()
        return if (result.isSuccessful && body != null) {
            ResultType.Success(body)
        } else {
            ResultType.Error(Failure.ServerFailure)
        }
    }
}