package com.santos.androidchallenge.domain.usecases

import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.domain.model.Lyrics
import com.santos.androidchallenge.domain.repository.SongRepository
import javax.inject.Inject

class GetLyricsUseCase @Inject constructor(private val songRepository: SongRepository) {
    suspend operator fun invoke(artist: String, song: String): ResultType<Lyrics, Failure> {
        return songRepository.getLyrics(artist, song)
    }
}