package com.santos.androidchallenge.data.datasource.interfaces

import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.data.entity.SongEntity

interface SongNetworkSource {

    suspend fun getSong(): ResultType<SongEntity, Failure>
}