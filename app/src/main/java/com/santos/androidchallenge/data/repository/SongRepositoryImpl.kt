package com.santos.androidchallenge.data.repository

import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.core.mapSuccess
import com.santos.androidchallenge.data.datasource.interfaces.SongNetworkSource
import com.santos.androidchallenge.data.mapper.toDomain
import com.santos.androidchallenge.domain.model.Song
import com.santos.androidchallenge.domain.repository.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(
    private val songNetworkSource: SongNetworkSource
) : SongRepository {

    override suspend fun getSong(): ResultType<Song, Failure> = withContext(Dispatchers.IO) {
        return@withContext songNetworkSource.getSong().mapSuccess { it.toDomain() }
    }
}