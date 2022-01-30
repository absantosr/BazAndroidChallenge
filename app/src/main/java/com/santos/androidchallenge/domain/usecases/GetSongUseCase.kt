package com.santos.androidchallenge.domain.usecases

import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.domain.model.Summary
import com.santos.androidchallenge.domain.repository.SongRepository
import javax.inject.Inject

class GetSongUseCase @Inject constructor(private val songRepository: SongRepository) {

    suspend operator fun invoke(term: String): ResultType<Summary, Failure> {
        return songRepository.fetchSong(term)
    }
}